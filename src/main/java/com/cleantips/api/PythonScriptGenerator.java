package com.cleantips.api;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PythonScriptGenerator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	StringBuffer imports=new StringBuffer();
	
	imports.append("from diagrams import Cluster, Diagram"+System.lineSeparator());
	imports.append("from diagrams.aws.compute import EC2"+System.lineSeparator());
	imports.append("from diagrams.aws.database import RDS"+System.lineSeparator());
	imports.append("from diagrams.aws.network import ELB"+System.lineSeparator());
    
    String fileName = "";
    
	BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
    
    writer.write(imports.toString());
    
    writer.close();
	}

}
