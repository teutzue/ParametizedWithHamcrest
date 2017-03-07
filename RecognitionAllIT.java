package net.sf.javaanpr.test.util;

import net.sf.javaanpr.imageanalysis.CarSnapshot;
import net.sf.javaanpr.intelligence.Intelligence;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by CosticaTeodor on 07/03/2017.
 */

@RunWith(Parameterized.class)
public class RecognitionAllIT {

    private Intelligence intel;
    private String exp;
    private File f;


    public RecognitionAllIT(File f, String exp) {
        this.f = f;
        this.exp = exp;
    }

    @Before
    public void setUp() throws Exception {
        intel = new Intelligence();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> checkPlate() throws IOException {
        String snapshotDirPath = "src/test/resources/snapshots";//de aici le ia
        String resultsPath = "src/test/resources/results.properties";
        InputStream resultsStream = new FileInputStream(new File(resultsPath));//face un stream cu path-ul de la imagini

        Properties properties = new Properties();
        properties.load(resultsStream);//incarca in proprietati
        resultsStream.close();
        assertTrue(properties.size() > 0);// verifica daca properietatile is > 0

        File snapshotDir = new File(snapshotDirPath);
        File[] snapshots = snapshotDir.listFiles();// array de snaphots
        assertNotNull(snapshots);
        assertTrue(snapshots.length > 0);

        Collection<Object[]> results = new ArrayList<>();
        for (File snap : snapshots) {
            String snapName = snap.getName();
            String plateCorrect = properties.getProperty(snapName);
            assertNotNull(plateCorrect);

            results.add(new Object[]{snap, plateCorrect});
        }
        return results;
    }

    @Test
    public void recogniseIt() throws IOException{
        CarSnapshot carSnap = new CarSnapshot(new FileInputStream(f));
        String read = intel.recognize(carSnap);
        assertThat(carSnap, notNullValue());
        assertThat(read, notNullValue());
        assertThat(exp, is(read));
    }

}





