
package com.appspot.stingion.controller.minor.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.appspot.stingion.controller.minor.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetItResponse_QNAME = new QName("http://soap.minor.controller.stingion.appspot.com/", "getItResponse");
    private final static QName _GetIt_QNAME = new QName("http://soap.minor.controller.stingion.appspot.com/", "getIt");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.appspot.stingion.controller.minor.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetItResponse }
     * 
     */
    public GetItResponse createGetItResponse() {
        return new GetItResponse();
    }

    /**
     * Create an instance of {@link GetIt }
     * 
     */
    public GetIt createGetIt() {
        return new GetIt();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetItResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.minor.controller.stingion.appspot.com/", name = "getItResponse")
    public JAXBElement<GetItResponse> createGetItResponse(GetItResponse value) {
        return new JAXBElement<GetItResponse>(_GetItResponse_QNAME, GetItResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.minor.controller.stingion.appspot.com/", name = "getIt")
    public JAXBElement<GetIt> createGetIt(GetIt value) {
        return new JAXBElement<GetIt>(_GetIt_QNAME, GetIt.class, null, value);
    }

}
