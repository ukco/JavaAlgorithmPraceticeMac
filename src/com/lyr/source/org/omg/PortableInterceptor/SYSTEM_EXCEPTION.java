package org.omg.PortableInterceptor;


/**
* org/omg/PortableInterceptor/SYSTEM_EXCEPTION.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /Users/java_re/workspace/8-2-build-macosx-x86_64/jdk8u212/12974/corba/src/share/classes/org/omg/PortableInterceptor/Interceptors.idl
* Monday, April 1, 2019 11:12:35 PM PDT
*/

public interface SYSTEM_EXCEPTION
{

  /**
     * Indicates a SystemException reply status. One possible value for 
     * <code>RequestInfo.reply_status</code>.
     * @see RequestInfo#reply_status
     * @see SUCCESSFUL
     * @see USER_EXCEPTION
     * @see LOCATION_FORWARD
     * @see TRANSPORT_RETRY
     */
  public static final short value = (short)(1);
}
