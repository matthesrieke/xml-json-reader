/*
 * An XML document type.
 * Localname: testdocument
 * Namespace: 
 * Java type: noNamespace.TestdocumentDocument
 *
 * Automatically generated - do not modify.
 */
package noNamespace.impl;
/**
 * A document containing one testdocument(@) element.
 *
 * This is a complex type.
 */
public class TestdocumentDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements noNamespace.TestdocumentDocument
{
    private static final long serialVersionUID = 1L;
    
    public TestdocumentDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TESTDOCUMENT$0 = 
        new javax.xml.namespace.QName("", "testdocument");
    
    
    /**
     * Gets the "testdocument" element
     */
    public noNamespace.TestdocumentDocument.Testdocument getTestdocument()
    {
        synchronized (monitor())
        {
            check_orphaned();
            noNamespace.TestdocumentDocument.Testdocument target = null;
            target = (noNamespace.TestdocumentDocument.Testdocument)get_store().find_element_user(TESTDOCUMENT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "testdocument" element
     */
    public void setTestdocument(noNamespace.TestdocumentDocument.Testdocument testdocument)
    {
        synchronized (monitor())
        {
            check_orphaned();
            noNamespace.TestdocumentDocument.Testdocument target = null;
            target = (noNamespace.TestdocumentDocument.Testdocument)get_store().find_element_user(TESTDOCUMENT$0, 0);
            if (target == null)
            {
                target = (noNamespace.TestdocumentDocument.Testdocument)get_store().add_element_user(TESTDOCUMENT$0);
            }
            target.set(testdocument);
        }
    }
    
    /**
     * Appends and returns a new empty "testdocument" element
     */
    public noNamespace.TestdocumentDocument.Testdocument addNewTestdocument()
    {
        synchronized (monitor())
        {
            check_orphaned();
            noNamespace.TestdocumentDocument.Testdocument target = null;
            target = (noNamespace.TestdocumentDocument.Testdocument)get_store().add_element_user(TESTDOCUMENT$0);
            return target;
        }
    }
    /**
     * An XML testdocument(@).
     *
     * This is a complex type.
     */
    public static class TestdocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements noNamespace.TestdocumentDocument.Testdocument
    {
        private static final long serialVersionUID = 1L;
        
        public TestdocumentImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ELEMENT1$0 = 
            new javax.xml.namespace.QName("", "element1");
        private static final javax.xml.namespace.QName ELEMENT2$2 = 
            new javax.xml.namespace.QName("", "element2");
        private static final javax.xml.namespace.QName ATTRIBUTE1$4 = 
            new javax.xml.namespace.QName("", "attribute1");
        
        
        /**
         * Gets the "element1" element
         */
        public java.lang.String getElement1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ELEMENT1$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "element1" element
         */
        public org.apache.xmlbeans.XmlString xgetElement1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ELEMENT1$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "element1" element
         */
        public void setElement1(java.lang.String element1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ELEMENT1$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ELEMENT1$0);
                }
                target.setStringValue(element1);
            }
        }
        
        /**
         * Sets (as xml) the "element1" element
         */
        public void xsetElement1(org.apache.xmlbeans.XmlString element1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ELEMENT1$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ELEMENT1$0);
                }
                target.set(element1);
            }
        }
        
        /**
         * Gets the "element2" element
         */
        public noNamespace.TestdocumentDocument.Testdocument.Element2 getElement2()
        {
            synchronized (monitor())
            {
                check_orphaned();
                noNamespace.TestdocumentDocument.Testdocument.Element2 target = null;
                target = (noNamespace.TestdocumentDocument.Testdocument.Element2)get_store().find_element_user(ELEMENT2$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "element2" element
         */
        public void setElement2(noNamespace.TestdocumentDocument.Testdocument.Element2 element2)
        {
            synchronized (monitor())
            {
                check_orphaned();
                noNamespace.TestdocumentDocument.Testdocument.Element2 target = null;
                target = (noNamespace.TestdocumentDocument.Testdocument.Element2)get_store().find_element_user(ELEMENT2$2, 0);
                if (target == null)
                {
                    target = (noNamespace.TestdocumentDocument.Testdocument.Element2)get_store().add_element_user(ELEMENT2$2);
                }
                target.set(element2);
            }
        }
        
        /**
         * Appends and returns a new empty "element2" element
         */
        public noNamespace.TestdocumentDocument.Testdocument.Element2 addNewElement2()
        {
            synchronized (monitor())
            {
                check_orphaned();
                noNamespace.TestdocumentDocument.Testdocument.Element2 target = null;
                target = (noNamespace.TestdocumentDocument.Testdocument.Element2)get_store().add_element_user(ELEMENT2$2);
                return target;
            }
        }
        
        /**
         * Gets the "attribute1" attribute
         */
        public java.lang.String getAttribute1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ATTRIBUTE1$4);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "attribute1" attribute
         */
        public org.apache.xmlbeans.XmlString xgetAttribute1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ATTRIBUTE1$4);
                return target;
            }
        }
        
        /**
         * Sets the "attribute1" attribute
         */
        public void setAttribute1(java.lang.String attribute1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ATTRIBUTE1$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ATTRIBUTE1$4);
                }
                target.setStringValue(attribute1);
            }
        }
        
        /**
         * Sets (as xml) the "attribute1" attribute
         */
        public void xsetAttribute1(org.apache.xmlbeans.XmlString attribute1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ATTRIBUTE1$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ATTRIBUTE1$4);
                }
                target.set(attribute1);
            }
        }
        /**
         * An XML element2(@).
         *
         * This is a complex type.
         */
        public static class Element2Impl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements noNamespace.TestdocumentDocument.Testdocument.Element2
        {
            private static final long serialVersionUID = 1L;
            
            public Element2Impl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName VALUE1$0 = 
                new javax.xml.namespace.QName("", "value1");
            private static final javax.xml.namespace.QName VALUE2$2 = 
                new javax.xml.namespace.QName("", "value2");
            
            
            /**
             * Gets the "value1" element
             */
            public java.lang.String getValue1()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VALUE1$0, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "value1" element
             */
            public org.apache.xmlbeans.XmlString xgetValue1()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(VALUE1$0, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "value1" element
             */
            public void setValue1(java.lang.String value1)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VALUE1$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(VALUE1$0);
                    }
                    target.setStringValue(value1);
                }
            }
            
            /**
             * Sets (as xml) the "value1" element
             */
            public void xsetValue1(org.apache.xmlbeans.XmlString value1)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(VALUE1$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(VALUE1$0);
                    }
                    target.set(value1);
                }
            }
            
            /**
             * Gets the "value2" element
             */
            public java.lang.String getValue2()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VALUE2$2, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "value2" element
             */
            public org.apache.xmlbeans.XmlString xgetValue2()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(VALUE2$2, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "value2" element
             */
            public void setValue2(java.lang.String value2)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VALUE2$2, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(VALUE2$2);
                    }
                    target.setStringValue(value2);
                }
            }
            
            /**
             * Sets (as xml) the "value2" element
             */
            public void xsetValue2(org.apache.xmlbeans.XmlString value2)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(VALUE2$2, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(VALUE2$2);
                    }
                    target.set(value2);
                }
            }
        }
    }
}
