package com.semrush;

import org.eclipse.persistence.oxm.annotations.XmlLocation;
import org.xml.sax.Locator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

    public int id;

    public String name;

    @XmlLocation
    @XmlTransient
    public Locator locator;

    @Override
    public String toString() {
        String loc = " noLoc";
        if (locator != null) {
            loc = " L" + locator.getLineNumber() +
                    " C" + locator.getColumnNumber() +
                    " " + locator.getSystemId();
        }

        return "Customer(" + name + ")" + loc;
    }


    @XmlLocation
    @XmlTransient
    public Locator getLocator() {
        return locator;
    }

    public Customer setLocator(Locator locator) {
        this.locator = locator;
        return this;
    }
}
