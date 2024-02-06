//tag::improve-javadoc[]
package de.dhbw.javadoc.exercises;

public interface XmlAdapter {

    /**
     * Purpose: plain text (string) --> xml
     * @param plainText the text
     * @return String
     */
    String toXml(String plainText);

    // Purpose: xml --> plain text (string)
    String fromXml(String xml) throws Exception;

    String adapt(String xmlOrPlainText) throws Exception;

}
//end::improve-javadoc[]