package no.imr.nmdapi.nmddataset.security.access.voters;

import java.util.Collection;
import java.util.HashSet;
import no.imr.nmdapi.dao.file.NMDSeriesReferenceDao;
import no.imr.nmdapi.nmddataset.controller.DatasetController;
import org.apache.commons.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDecisionVoter;
import static org.springframework.security.access.AccessDecisionVoter.ACCESS_ABSTAIN;
import static org.springframework.security.access.AccessDecisionVoter.ACCESS_DENIED;
import static org.springframework.security.access.AccessDecisionVoter.ACCESS_GRANTED;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Service;

/**
 * Access decision voter for cruiseseries data. All cruiseseries information is
 * always available for read.
 *
 * @author kjetilf
 */
@Service
public class DatasetAccessDecisionVoter implements AccessDecisionVoter<FilterInvocation> {

    @Autowired
    private NMDSeriesReferenceDao seriesReferenceDao;

    @Autowired
    private Configuration configuration;

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(FilterInvocation.class);
    }

    @Override
    public int vote(Authentication auth, FilterInvocation obj, Collection<ConfigAttribute> confAttrs) {
        String[] args = obj.getRequestUrl().split("/");
        if (obj.getFullRequestUrl().contains(DatasetController.DATASET_URL)) {
            if (obj.getHttpRequest().getMethod().equalsIgnoreCase(HttpMethod.PUT.name())) {
                Collection<String> auths = getAuths(auth.getAuthorities());
                String adminRole = configuration.getString("admin.role");
                if (auth.isAuthenticated() && auth.getAuthorities().contains(new SimpleGrantedAuthority(adminRole))) {
                    return ACCESS_GRANTED;
                } else {
                    return ACCESS_DENIED;
                }
            } else {
                return ACCESS_GRANTED;
            }
        } else {
            // Not reference data.
            return ACCESS_ABSTAIN;
        }
    }

    private Collection<String> getAuths(Collection<? extends GrantedAuthority> auths) {
        Collection<String> authsStr = new HashSet<String>();
        for (GrantedAuthority authority : auths) {
            authsStr.add(authority.getAuthority());
        }
        return authsStr;
    }

}
