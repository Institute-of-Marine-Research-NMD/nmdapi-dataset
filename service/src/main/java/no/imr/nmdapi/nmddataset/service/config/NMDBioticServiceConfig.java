package no.imr.nmdapi.nmddataset.service.config;

import no.imr.nmdapi.nmddataset.service.NMDDatasetService;
import no.imr.nmdapi.nmddataset.service.NMDDatasetServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Service layer configuration.
 *
 * @author kjetilf
 */
@Configuration
public class NMDBioticServiceConfig {

    /**
     * Creates the service implementation.
     *
     * @return  A reference service implementation.
     */
    @Bean(name="nmdBioticService")
    public NMDDatasetService getNMDMissionQueryService() {
        return new NMDDatasetServiceImpl();
    }

}
