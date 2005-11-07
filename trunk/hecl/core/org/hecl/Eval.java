/* Copyright 2004-2005 David N. Welton

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package org.hecl;

/**
 * <code>Eval</code> takes care of evaluating code.
 * 
 * @author <a href="mailto:davidw@dedasys.com">David N. Welton </a>
 * @version 1.0
 */
public class Eval {

    public Eval() {
    }

    /**
     * The <code>eval</code> method evaluates some Hecl code passed to it.
     * 
     * @param interp
     *            an <code>Interp</code>.
     * @param in
     *            a <code>Thing</code> value representing the text to
     *            evaluate.
     * @return a <code>Thing</code> value - the result of the evaluation.
     * @exception HeclException
     *                if an error occurs.
     */
    public static Thing eval(Interp interp, Thing in) throws HeclException {
	CodeThing.get(interp, in).run(interp);
	return interp.result;
    }
}
