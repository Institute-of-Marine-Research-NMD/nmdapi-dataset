package no.imr.nmdapi.nmddataset.service;

import no.imr.nmd.commons.dataset.jaxb.DatasetType;
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
     * @param pathvars
     * @return
     */
    ListElementType getList(String... pathvars);

    /**
     *
     * @param missiontype
     * @param year
     * @param platform
     * @param delivery
     */
    void updateDataset(String missiontype, String year, String platform, String delivery, DatasetType dataset);

}
