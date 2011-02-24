package com.softlang.company;

import java.io.InputStream;
import java.io.IOException;
import org.eclipse.imp.parser.IParseController;
import org.strategoxt.imp.runtime.Environment;
import org.strategoxt.imp.runtime.dynamicloading.BadDescriptorException;
import org.strategoxt.imp.runtime.dynamicloading.Descriptor;
import org.strategoxt.imp.runtime.dynamicloading.DescriptorFactory;
import org.strategoxt.imp.runtime.dynamicloading.DynamicParseController;

public class CompanyParseController extends DynamicParseController 
{ 
  public static final String LANGUAGE = new String("Company");

  private static final String TABLE = "/include/" + LANGUAGE + ".tbl";

  private static final String DESCRIPTOR = "/include/" + LANGUAGE + ".packed.esv";

  private static volatile Descriptor descriptor;

  private static Throwable notLoadingCause;

  public static synchronized Descriptor getDescriptor()
  { 
    if(notLoadingCause != null)
      throw new RuntimeException(notLoadingCause);
    if(descriptor == null)
      createDescriptor();
    return descriptor;
  }

  private static void createDescriptor()
  { 
    try
    { 
      InputStream descriptorStream = CompanyParseController.class.getResourceAsStream(DESCRIPTOR);
      InputStream table = CompanyParseController.class.getResourceAsStream(TABLE);
      if(descriptorStream == null)
        throw new BadDescriptorException("Could not load descriptor file from " + DESCRIPTOR + " (not found in plugin: " + getPluginLocation() + ")");
      if(table == null)
        throw new BadDescriptorException("Could not load parse table from " + TABLE + " (not found in plugin: " + getPluginLocation() + ")");
      descriptor = DescriptorFactory.load(descriptorStream, table, null);
      descriptor.setAttachmentProvider(CompanyParseController.class);
    }
    catch(BadDescriptorException exc)
    { 
      notLoadingCause = exc;
      Environment.logException("Bad descriptor for " + LANGUAGE + " plugin", exc);
      throw new RuntimeException("Bad descriptor for " + LANGUAGE + " plugin", exc);
    }
    catch(IOException exc)
    { 
      notLoadingCause = exc;
      Environment.logException("I/O problem loading descriptor for " + LANGUAGE + " plugin", exc);
      throw new RuntimeException("I/O problem loading descriptor for " + LANGUAGE + " plugin", exc);
    }
  }

  private static String getPluginLocation()
  { 
    return CompanyParseController.class.getProtectionDomain().getCodeSource().getLocation().getFile();
  }

  @Override public IParseController getWrapped()
  { 
    if(!isInitialized())
    { 
      if(notLoadingCause != null)
        throw new RuntimeException(notLoadingCause);
      try
      { 
        initialize(this, getDescriptor().getLanguage());
      }
      catch(BadDescriptorException exc)
      { 
        notLoadingCause = exc;
        throw new RuntimeException(exc);
      }
    }
    return super.getWrapped();
  }

  @Override protected void setNotLoadingCause(Throwable value)
  { 
    notLoadingCause = value;
    super.setNotLoadingCause(value);
  }
}