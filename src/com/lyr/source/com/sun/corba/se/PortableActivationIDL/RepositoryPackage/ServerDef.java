package com.sun.corba.se.PortableActivationIDL.RepositoryPackage;


/**
* com/sun/corba/se/PortableActivationIDL/RepositoryPackage/ServerDef.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /Users/java_re/workspace/8-2-build-macosx-x86_64/jdk8u212/12974/corba/src/share/classes/com/sun/corba/se/PortableActivationIDL/activation.idl
* Monday, April 1, 2019 11:12:33 PM PDT
*/

public final class ServerDef implements org.omg.CORBA.portable.IDLEntity
{
  public String applicationName = null;

  // serverName values.
  public String serverName = null;

  // Class name of server's main class.
  public String serverClassPath = null;

  // class path used to run the server.
  public String serverArgs = null;

  // arguments passed to the server
  public String serverVmArgs = null;

  // arguments passed to the server's Java VM1
  public boolean isInstalled = false;

  public ServerDef ()
  {
  } // ctor

  public ServerDef (String _applicationName, String _serverName, String _serverClassPath, String _serverArgs, String _serverVmArgs, boolean _isInstalled)
  {
    applicationName = _applicationName;
    serverName = _serverName;
    serverClassPath = _serverClassPath;
    serverArgs = _serverArgs;
    serverVmArgs = _serverVmArgs;
    isInstalled = _isInstalled;
  } // ctor

} // class ServerDef
