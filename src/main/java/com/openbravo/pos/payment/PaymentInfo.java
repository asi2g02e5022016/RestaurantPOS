//    AgilePOS  - Touch Friendly Point Of Sale
//    Copyright (C) 2010-2013 uniCenta
//    Copyright (C) 2008-2009 Openbravo, S.L.
//    http://www.unicenta.com
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

package com.openbravo.pos.payment;

import com.openbravo.format.Formats;

/**
 *
 * @author JG uniCenta
 */
public abstract class PaymentInfo {
    
    /**
     *
     * @return
     */
    public abstract String getName();

    /**
     *
     * @return
     */
    public abstract double getTotal();

    /**
     *
     * @return
     */
    public abstract PaymentInfo copyPayment();

    /**
     *
     * @return
     */
    public abstract String getTransactionID();

    /**
     *
     * @return
     */
    public abstract double getPaid();

    /**
     *
     * @return
     */
    public abstract double getChange();

    /**
     *
     * @return
     */
    public abstract double getTendered();

    /**
     *
     * @return
     */
    public abstract String getCardName();
    
    /**
     *
     * @return
     */
    public String printTotal() {
        return Formats.CURRENCY.formatValue(getTotal());
    }
}
