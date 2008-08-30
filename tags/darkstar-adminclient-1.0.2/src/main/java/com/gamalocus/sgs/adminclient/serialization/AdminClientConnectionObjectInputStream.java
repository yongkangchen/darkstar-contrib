/**
 * 
 */
package com.gamalocus.sgs.adminclient.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamClass;
import java.util.Map;
import java.util.logging.Logger;

import com.gamalocus.sgs.adminclient.connection.AdminClientConnection;


public class AdminClientConnectionObjectInputStream extends CustomClassLoaderObjectInputStream
{
	private final static Logger logger = Logger.getLogger(AdminClientConnectionObjectInputStream.class.getName());
	
	private AdminClientConnection connection;
	
	public AdminClientConnectionObjectInputStream(InputStream in,
			ClassLoader replacementClassLoader, 
			Map<String, ObjectStreamClass> classReplacements,
			AdminClientConnection connection) throws IOException
	{
		super(in, classReplacements, null, 
				replacementClassLoader != null ? replacementClassLoader : 
					AdminClientConnectionObjectInputStream.class.getClassLoader());
		this.connection = connection;
	}

	public AdminClientConnection getConnection()
	{
		return connection;
	}
}