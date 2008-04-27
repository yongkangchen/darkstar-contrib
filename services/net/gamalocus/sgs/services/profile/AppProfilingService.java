package net.gamalocus.sgs.services.profile;

import java.util.Properties;
import java.util.logging.Logger;

import com.sun.sgs.impl.sharedutil.PropertiesWrapper;
import com.sun.sgs.kernel.ComponentRegistry;
import com.sun.sgs.kernel.Manageable;
import com.sun.sgs.service.DataService;
import com.sun.sgs.service.Service;
import com.sun.sgs.service.TransactionProxy;

/**
 * The MySQLService.
 * 
 * @author Emanuel Greisen
 * 
 */
public class AppProfilingService implements Service, Manageable
{
	/** The name of this class. */
	static final String CLASSNAME = AppProfilingService.class.getName();
	/** the logger. */
	private final static Logger logger = Logger.getLogger(AppProfilingService.class.getName());
	
    // a proxy providing access to the transaction state
    static TransactionProxy transactionProxy = null;

    // the data service used in the same context
    static DataService dataService;

	/**
	 * The constructor as it is called from SGS.
	 * 
	 * @param properties
	 * @param componentRegistry
	 * @param transProxy
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public AppProfilingService(Properties properties, ComponentRegistry componentRegistry, TransactionProxy transProxy) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		// Read properties
		PropertiesWrapper wrappedProps = new PropertiesWrapper(properties);
		
		// Save for later
		transactionProxy = transProxy;
		dataService = transProxy.getService(DataService.class);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName()
	{
		return toString();
	}

	@Override
	public String toString()
	{
		return CLASSNAME;
	}

	/**
	 * do nothing.
	 */
	public void ready() throws Exception
	{
	}

	/**
	 * Here we terminate our worker thread, and close our mysql connection.
	 */
	public boolean shutdown()
	{
		return true; // ok, we are down
	}
}
