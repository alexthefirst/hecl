/*
 * Copyright 2005-2007
 * Wolfgang S. Kechel, data2c GmbH (www.data2c.com)
 * 
 * Author: Wolfgang S. Kechel - wolfgang.kechel@data2c.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.hecl.midp20.lcdui;

import javax.microedition.lcdui.Ticker;

import org.hecl.HeclException;
import org.hecl.Interp;
import org.hecl.ObjectThing;
import org.hecl.Properties;
import org.hecl.StringThing;
import org.hecl.Thing;

public class TickerCmd extends OptionCmd {
    public static void load(Interp ip) {
	ip.addCommand(CMDNAME,cmd);
	ip.addClassCmd(Ticker.class,cmd);
    }
    public static void unload(Interp ip) {
	ip.removeCommand(CMDNAME);
	ip.removeClassCmd(Ticker.class);
    }
    
    public Thing cmdCode(Interp interp,Thing[] argv) throws HeclException {
	Properties p = WidgetInfo.defaultProps(Ticker.class);
	p.setProps(argv,1);
	Ticker w = new Ticker(p.getProp(WidgetInfo.NTEXT).toString());
	p.delProp(WidgetInfo.NTEXT);
	return ObjectThing.create(setInstanceProperties(interp,w,p));
    }

    private TickerCmd() {}
	
    public Thing cget(Interp ip,Object target,String optname) throws HeclException {
	Ticker ticker = (Ticker)target;
	
	if(optname.equals(WidgetInfo.NTEXT))
	    return StringThing.create(ticker.getString());
	return super.cget(ip,target,optname);
    }

    public void cset(Interp ip,Object target,String optname,Thing optval)
	throws HeclException {
	Ticker ticker = (Ticker)target;
	
	if(optname.equals(WidgetInfo.NTEXT)) {
	    ticker.setString(optval.toString());
	    return;
	}
	super.cset(ip,target,optname,optval);
    }

    private static TickerCmd cmd = new TickerCmd();
    private static final String CMDNAME = "lcdui.ticker";
}
    
// Variables:
// mode:java
// coding:utf-8
// End:
