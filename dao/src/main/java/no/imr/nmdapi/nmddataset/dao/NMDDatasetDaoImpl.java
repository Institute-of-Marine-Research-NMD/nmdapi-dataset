package no.imr.nmdapi.nmddataset.dao;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import no.imr.nmd.commons.dataset.jaxb.DatasetsType;
import no.imr.nmdapi.exceptions.NotFoundException;
import org.apache.commons.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Data Access layer implementation for biotic data.
 *
 * @author kjetilf
 */
public class NMDDatasetDaoImpl implements NMDDatasetDao {

    /**
     * File name used to store data.
     */
    private static final String FILENAME = "data.xml";

    /**
     * Common data dao.
     */
    @Autowired
    private NMDDataDao dataDao;

    /**
     * Common properties.
     */
    @Autowired
    private Configuration configuration;

    @Override
    public Object getByMission(final String missiontype, final String year, final String platform, final String delivery) {
        String predir = configuration.getString("pre.data.dir");
        File file = getFile(missiontype, year, platform, delivery, predir);
        if (file.exists()) {
            return dataDao.getFile(DatasetsType.class, file);
        } else {
            throw new NotFoundException(getFile(missiontype, year, platform, delivery, predir) + " does not exist.");
        }
    }

    @Override
    public boolean hasData(String missiontype, String year, String platform, String delivery) {
        String predir = configuration.getString("pre.data.dir");
        File file = getFile(missiontype, year, platform, delivery, predir);
       return  file.exists();
    }

    /**
     *
     * @param missiontype
     * @param year
     * @param platform
     * @param delivery
     * @param predir
     * @param postdir
     * @return
     */
    private File getFile(final String missiontype, final String year, final String platform, final String delivery, final String predir) {
        return new File(predir + System.getProperty("file.separator") + missiontype + System.getProperty("file.separator") + year + System.getProperty("file.separator") + platform + System.getProperty("file.separator") + delivery + System.getProperty("file.separator") + FILENAME);
    }

    @Override
    public List<String> getDirs(String... pathvars) {
        List<String> res = new ArrayList<String>();
        File dir = new File(configuration.getString("pre.data.dir"));
        for (String var : pathvars) {
            dir = new File(dir.getAbsolutePath() + System.getProperty("file.separator") + var);
        }
        if (!dir.exists()) {
            throw new NotFoundException("Could not find directory: " + dir.getAbsolutePath());
        }
        for (File dirIt : dir.listFiles()) {
            if (dirIt.isDirectory()) {
                res.add(dirIt.getName());
            }
        }
        return res;
    }


}
