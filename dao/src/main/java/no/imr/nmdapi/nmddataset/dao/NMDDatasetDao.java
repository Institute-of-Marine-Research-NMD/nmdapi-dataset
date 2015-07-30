package no.imr.nmdapi.nmddataset.dao;

import no.imr.nmd.commons.dataset.jaxb.DatasetsType;

/**
 * Data access API for biotic data.
 *
 * @author kjetilf
 */
public interface NMDDatasetDao {

    /**
     * Return mission data.
     *
     * @param <T>   Type of class to return.
     * @param missiontype
     * @param year
     * @param platform
     * @param delivery
     * @return              Mission object.
     */
    <T> T getByMission(String missiontype, String year, String platform, String delivery);

    /**
     *
     * @param missiontype
     * @param year
     * @param platform
     * @param delivery
     * @return  True if data exists.
     */
    boolean hasData(String missiontype, String year, String platform, String delivery);

}
