//    AgilePOS  - Touch Friendly Point Of Sale
//    Copyright (c) 2016 AgilePOs
//    http://www.agilepos.com
//
//    This file is part of AgilePOS
//
//    AgilePOS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   AgilePOS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with AgilePOS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.sales;

import com.openbravo.data.loader.IKeyed;
import java.io.Serializable;

/**
 *
 * @author lportillo
 */
public class DocumentType implements Serializable, IKeyed {
    
    private static final long serialVersionUID = -2705212098856473044L;
    private String id;
    private String name;

    
    /** Creates new DocumentType
     * @param id
     * @param name */
    public DocumentType(String id, String name) {
        this.id = id;
        this.name = name;
      
    }
    
    /**
     *
     * @return
     */
    public Object getKey() {
        return id;
    }
    
    /**
     *
     * @param value
     */
    public void setID(String value) {
        id = value;
    }
    
    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }
    
    /**
     *
     * @param value
     */
    public void setName(String value) {
        name = value;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
