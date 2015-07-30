package no.imr.nmdapi.nmddataset.service;

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

}
