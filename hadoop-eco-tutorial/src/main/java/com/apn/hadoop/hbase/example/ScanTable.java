package com.apn.hadoop.hbase.example;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

public class ScanTable {
	public static void main(String args[]) throws IOException {
		// Instantiating Configuration class
		Configuration config = HBaseConfiguration.create();
		// Instantiating HTable class
		HTable table = new HTable(config, "emp");
		// Instantiating the Scan class
		Scan scan = new Scan();
		// Scanning the required columns
		scan.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("name"));
		scan.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("city"));
		// Getting the scan result
		ResultScanner scanner = table.getScanner(scan);
		// Reading values from scan result
		for (Result result = scanner.next(); result != null; result = scanner.next())
			System.out.println("Found row : " + result);
		// closing the scanner
		scanner.close();
	}
}