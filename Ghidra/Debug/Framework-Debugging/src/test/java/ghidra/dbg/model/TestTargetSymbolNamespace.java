/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ghidra.dbg.model;

import java.util.List;

import ghidra.dbg.attributes.TargetDataType;
import ghidra.dbg.target.TargetSymbolNamespace;
import ghidra.program.model.address.Address;

public class TestTargetSymbolNamespace
		extends DefaultTestTargetObject<TestTargetSymbol, TestTargetObject>
		implements TargetSymbolNamespace<TestTargetSymbolNamespace> {

	public TestTargetSymbolNamespace(TestTargetObject parent) {
		super(parent, "Symbols", "SymbolNamespace");
	}

	public TestTargetSymbol addSymbol(String name, Address address, long size,
			TargetDataType dataType) {
		TestTargetSymbol symbol = new TestTargetSymbol(this, name, address, size, dataType);
		changeElements(List.of(), List.of(symbol), "Added symbol " + name);
		return symbol;
	}
}
