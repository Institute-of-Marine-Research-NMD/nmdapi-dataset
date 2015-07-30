package no.imr.nmdapi.nmddataset.dao;

import java.io.File;

/**
 * This handles generic marshall and unmarshall objects to the
 * directory structure.
 *
 * @author kjetilf
 */
public interface NMDDataDao {

    /**
     * Unmarshall the file.
     *
     * @param <T>   Type of class to unmarshall.
     * @param aClass    Type of class to unmarshall
     * @param file  File to unmarshall.
     * @return  Unmarshalled object.
     */
    <T> T getFile(final Class<T> aClass, final File file);

    /**
     * Unmarshall file.
     *
     * @param packageName   Package containing jaxb objects.
     * @param file          File to unmarshall.
     * @return              Unmarshalled object.
     */
    Object getFile(String packageName, File file);
}
