package no.imr.nmdapi.nmddataset.service;

import java.util.Map;
import no.imr.nmdapi.generic.response.v1.ListElementType;

/**
 * This service API only support queries.
 *
 * @author kjetilf
 */
public interface NMDDatasetService {

    /**
     * Get mission.
     *
     * @param missiontype
     * @param year
     * @param platform
     * @param delivery
     * @return              JAXB object.
     */
    Object getByMission(String missiontype, String year, String platform, String delivery);

    /**
     * Has data.
     *
     * @param missiontype
     * @param year
     * @param platform
     * @param delivery
     * @return      True if data exists.
     */
    boolean hasData(String missiontype, String year, String platform, String delivery);

    /**
     * Get discovery.
     *
     * @param pathVariables
     * @return
     */
    ListElementType getList(String... pathvars);

}
