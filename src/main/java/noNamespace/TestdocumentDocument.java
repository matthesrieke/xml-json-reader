/*
 * An XML document type.
 * Localname: testdocument
 * Namespace: 
 * Java type: noNamespace.TestdocumentDocument
 *
 * Automatically generated - do not modify.
 */
package noNamespace;


/**
 * A document containing one testdocument(@) element.
 *
 * This is a complex type.
 */
public interface TestdocumentDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(TestdocumentDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s2B23D4C3719FCEFEB8787EC1E7F7DBC5").resolveHandle("testdocument7ea6doctype");
    
    /**
     * Gets the "testdocument" element
     */
    noNamespace.TestdocumentDocument.Testdocument getTestdocument();
    
    /**
     * Sets the "testdocument" element
     */
    void setTestdocument(noNamespace.TestdocumentDocument.Testdocument testdocument);
    
    /**
     * Appends and returns a new empty "testdocument" element
     */
    noNamespace.TestdocumentDocument.Testdocument addNewTestdocument();
    
    /**
     * An XML testdocument(@).
     *
     * This is a complex type.
     */
    public interface Testdocument extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Testdocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s2B23D4C3719FCEFEB8787EC1E7F7DBC5").resolveHandle("testdocumentc34delemtype");
        
        /**
         * Gets the "element1" element
         */
        java.lang.String getElement1();
        
        /**
         * Gets (as xml) the "element1" element
         */
        org.apache.xmlbeans.XmlString xgetElement1();
        
        /**
         * Sets the "element1" element
         */
        void setElement1(java.lang.String element1);
        
        /**
         * Sets (as xml) the "element1" element
         */
        void xsetElement1(org.apache.xmlbeans.XmlString element1);
        
        /**
         * Gets the "element2" element
         */
        noNamespace.TestdocumentDocument.Testdocument.Element2 getElement2();
        
        /**
         * Sets the "element2" element
         */
        void setElement2(noNamespace.TestdocumentDocument.Testdocument.Element2 element2);
        
        /**
         * Appends and returns a new empty "element2" element
         */
        noNamespace.TestdocumentDocument.Testdocument.Element2 addNewElement2();
        
        /**
         * Gets the "attribute1" attribute
         */
        java.lang.String getAttribute1();
        
        /**
         * Gets (as xml) the "attribute1" attribute
         */
        org.apache.xmlbeans.XmlString xgetAttribute1();
        
        /**
         * Sets the "attribute1" attribute
         */
        void setAttribute1(java.lang.String attribute1);
        
        /**
         * Sets (as xml) the "attribute1" attribute
         */
        void xsetAttribute1(org.apache.xmlbeans.XmlString attribute1);
        
        /**
         * An XML element2(@).
         *
         * This is a complex type.
         */
        public interface Element2 extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Element2.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s2B23D4C3719FCEFEB8787EC1E7F7DBC5").resolveHandle("element2e70felemtype");
            
            /**
             * Gets the "value1" element
             */
            java.lang.String getValue1();
            
            /**
             * Gets (as xml) the "value1" element
             */
            org.apache.xmlbeans.XmlString xgetValue1();
            
            /**
             * Sets the "value1" element
             */
            void setValue1(java.lang.String value1);
            
            /**
             * Sets (as xml) the "value1" element
             */
            void xsetValue1(org.apache.xmlbeans.XmlString value1);
            
            /**
             * Gets the "value2" element
             */
            java.lang.String getValue2();
            
            /**
             * Gets (as xml) the "value2" element
             */
            org.apache.xmlbeans.XmlString xgetValue2();
            
            /**
             * Sets the "value2" element
             */
            void setValue2(java.lang.String value2);
            
            /**
             * Sets (as xml) the "value2" element
             */
            void xsetValue2(org.apache.xmlbeans.XmlString value2);
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static noNamespace.TestdocumentDocument.Testdocument.Element2 newInstance() {
                  return (noNamespace.TestdocumentDocument.Testdocument.Element2) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static noNamespace.TestdocumentDocument.Testdocument.Element2 newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (noNamespace.TestdocumentDocument.Testdocument.Element2) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static noNamespace.TestdocumentDocument.Testdocument newInstance() {
              return (noNamespace.TestdocumentDocument.Testdocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static noNamespace.TestdocumentDocument.Testdocument newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (noNamespace.TestdocumentDocument.Testdocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static noNamespace.TestdocumentDocument newInstance() {
          return (noNamespace.TestdocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static noNamespace.TestdocumentDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (noNamespace.TestdocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static noNamespace.TestdocumentDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (noNamespace.TestdocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static noNamespace.TestdocumentDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (noNamespace.TestdocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static noNamespace.TestdocumentDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.TestdocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static noNamespace.TestdocumentDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.TestdocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static noNamespace.TestdocumentDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.TestdocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static noNamespace.TestdocumentDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.TestdocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static noNamespace.TestdocumentDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.TestdocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static noNamespace.TestdocumentDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.TestdocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static noNamespace.TestdocumentDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.TestdocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static noNamespace.TestdocumentDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (noNamespace.TestdocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static noNamespace.TestdocumentDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (noNamespace.TestdocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static noNamespace.TestdocumentDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (noNamespace.TestdocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static noNamespace.TestdocumentDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (noNamespace.TestdocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static noNamespace.TestdocumentDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (noNamespace.TestdocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static noNamespace.TestdocumentDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (noNamespace.TestdocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static noNamespace.TestdocumentDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (noNamespace.TestdocumentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
