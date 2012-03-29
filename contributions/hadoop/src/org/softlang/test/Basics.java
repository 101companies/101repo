package org.softlang.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.softlang.operations.Cut;
import org.softlang.operations.Total;

public class Basics {
	private FileSystem fs;
	private String companyPath;
	private Path totalOut;
	private Configuration conf;
	private final double SAMPLE_SALARY_SUM = 399747;

	@Before
	public void setUp() throws IOException {
		conf = new Configuration();
		companyPath = "sampleCompany";
		totalOut = new Path(companyPath + "/out");

		fs = totalOut.getFileSystem(conf);

	}

	@Test
	public void testTotal() throws Exception {
		Total.total("meganalysis", companyPath, totalOut.toString());

		assertEquals(SAMPLE_SALARY_SUM, fetchOutputFromDisk().get(), 0);
	}

	@Test
	public void testCut() throws Exception {

		Cut.cut("meganalysis", companyPath);

		Total.total("meganalysis", companyPath, totalOut.toString());

		assertEquals(SAMPLE_SALARY_SUM / 2, fetchOutputFromDisk().get(), 0);

	}

	private DoubleWritable fetchOutputFromDisk() {
		DoubleWritable totalVal = new DoubleWritable();
		try {
			SequenceFile.Reader companyReader = new SequenceFile.Reader(fs, new Path(
					totalOut.toString() + "/part-r-00000"), conf);
			companyReader.next(new Text(), totalVal);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return totalVal;
	}

	@After
	public void deleteOutput() throws IOException {
		fs.delete(totalOut, true);
	}
}
