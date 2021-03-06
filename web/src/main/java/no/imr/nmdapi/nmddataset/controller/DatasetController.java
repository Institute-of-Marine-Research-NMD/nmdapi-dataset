package no.imr.nmdapi.nmddataset.controller;

import javax.servlet.http.HttpServletResponse;
import no.imr.framework.logging.slf4j.aspects.stereotype.ArgumentLogging;
import no.imr.framework.logging.slf4j.aspects.stereotype.PerformanceLogging;
import no.imr.nmd.commons.dataset.jaxb.DatasetType;
import no.imr.nmdapi.generic.response.v1.ListElementType;
import no.imr.nmdapi.nmddataset.service.NMDDatasetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller for dataset data.
 *
 * @author kjetilf
 */
@Controller
public class DatasetController {

    /**
     * Url part that defines it as dataset.
     */
    public static final String DATASET_URL = "/nmddataset";

    /**
     * Class logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DatasetController.class);

    /**
     * Service layer object for nmd dataset queries.
     */
    @Autowired
    private NMDDatasetService nmdDatasetService;

    /**
     * Get dataset data for mission.
     *
     * @param missiontype
     * @param year
     * @param platform
     * @param delivery
     * @return  Response object.
     */
    @PerformanceLogging
    @ArgumentLogging
    @RequestMapping(value = "/{missiontype}/{year}/{platform}/{delivery}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object findByMission(@PathVariable(value = "missiontype") String missiontype, @PathVariable(value = "year") String year, @PathVariable(value = "platform") String platform, @PathVariable(value = "delivery") String delivery) {
        LOGGER.info("Start DatasetController.findByMission: ");
        return nmdDatasetService.getByMission(missiontype, year, platform, delivery);
    }

    /**
     * Get dataset data for mission.
     *
     * @param missiontype
     * @param year
     * @param platform
     * @param delivery
     */
    @PerformanceLogging
    @ArgumentLogging
    @RequestMapping(value = "/{missiontype}/{year}/{platform}/{delivery}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void updateByMission(@PathVariable(value = "missiontype") String missiontype, @PathVariable(value = "year") String year, @PathVariable(value = "platform") String platform, @PathVariable(value = "delivery") String delivery, @RequestBody DatasetType dataset) {
        LOGGER.info("Start DatasetController.updateByMission: ");
        nmdDatasetService.updateDataset(missiontype, year, platform, delivery, dataset);
    }

    /**
     * Does the mission have data.
     *
     * @param missiontype
     * @param year
     * @param platform
     * @param delivery
     * @return
     */
    @PerformanceLogging
    @ArgumentLogging
    @RequestMapping(value = "/{missiontype}/{year}/{platform}/{delivery}", method = RequestMethod.HEAD)
    public void  hasData(HttpServletResponse httpServletResponse,@PathVariable(value = "missiontype") String missiontype, @PathVariable(value = "year") String year, @PathVariable(value = "platform") String platform, @PathVariable(value = "delivery") String delivery) {
        LOGGER.info("Start DatasetController.hasData");
         if (nmdDatasetService.hasData(missiontype, year, platform, delivery))  {
           httpServletResponse.setStatus(HttpServletResponse.SC_OK);
         }
         else {
             httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
         }
    }

    @PerformanceLogging
    @ArgumentLogging
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ListElementType getList() {
        LOGGER.info("Start DatasetController.getList");
        return nmdDatasetService.getList();
    }

    @PerformanceLogging
    @ArgumentLogging
    @RequestMapping(value = "/{missiontype}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ListElementType getList(@PathVariable(value = "missiontype") String missiontype) {
        LOGGER.info("Start DatasetController.getList");
        return nmdDatasetService.getList(missiontype);
    }

    @PerformanceLogging
    @ArgumentLogging
    @RequestMapping(value = "/{missiontype}/{year}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ListElementType getList(@PathVariable(value = "missiontype") String missiontype, @PathVariable(value = "year") String year) {
        LOGGER.info("Start DatasetController.getList");
        return nmdDatasetService.getList(missiontype, year);
    }

    @PerformanceLogging
    @ArgumentLogging
    @RequestMapping(value = "/{missiontype}/{year}/{platform}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ListElementType getList(@PathVariable(value = "missiontype") String missiontype, @PathVariable(value = "year") String year, @PathVariable(value = "platform") String platform) {
        LOGGER.info("Start DatasetController.getList");
        return nmdDatasetService.getList(missiontype, year, platform);
    }

}
