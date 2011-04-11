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
import org.softlang.operations.CutMapper;
import org.softlang.operations.Total;
import org.softlang.operations.TotalMapper;

public class Basics {
	private FileSystem fs;
	private Path totalOut;
	private Path cutOut;
	private Configuration conf;
	private final double SAMPLE_SALARY_SUM = 399747;
	
	@Before
	public void setUp() throws IOException{
		conf = new Configuration();
		totalOut = new Path("sampleCompany/out");
		cutOut = new Path("sampleCompany");
		
		fs = cutOut.getFileSystem(conf);
		
	}
	
	@Test
	public void testTotal() throws Exception {
		Total t = new Total();
		
		t.total(TotalMapper.CompanyMapper.class, "meganalysis", "sampleCompany", totalOut.toString());
		
		assertEquals(SAMPLE_SALARY_SUM, fetchOutputFromDisk().get(), 0);
	}
	
	@Test
	public void testCut() throws Exception {
		
		Cut c = new Cut();
		c.cut(CutMapper.CompanyMapper.class, "meganalysis", "sampleCompany", cutOut.toString());
		
		Total t = new Total();
		t.total(TotalMapper.CompanyMapper.class, "meganalysis", "sampleCompany", totalOut.toString());
		
		assertEquals(SAMPLE_SALARY_SUM/2, fetchOutputFromDisk().get(), 0);
		
	}
	
	private DoubleWritable fetchOutputFromDisk(){
		DoubleWritable totalVal = new DoubleWritable();
		try {
			SequenceFile.Reader companyReader = new SequenceFile.Reader(fs, new Path(totalOut.toString() + "/part-r-00000"), conf); 
			companyReader.next(new Text(), totalVal);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return totalVal;
	}
	
	@After
	public void deleteOutput() throws IOException{
		fs.delete(totalOut, true);
	}
}
