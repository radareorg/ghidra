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
package ghidra.dbg.target;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

import ghidra.dbg.DebugModelConventions;
import ghidra.dbg.DebuggerTargetObjectIface;

/**
 * A container of data types
 * 
 * The debugger should present these in as granular of unit as possible. Consider a desktop
 * application, for example. The debugger should present each module as a namespace rather than the
 * entire target (or worse, the entire session) as a single namespace.
 */
@DebuggerTargetObjectIface("DataTypeNamespace")
public interface TargetDataTypeNamespace<T extends TargetDataTypeNamespace<T>>
		extends TypedTargetObject<T> {
	enum Private {
		;
		private abstract class Cls implements TargetDataTypeNamespace<Cls> {
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	Class<Private.Cls> tclass = (Class) TargetDataTypeNamespace.class;

	/**
	 * Get the types in this namespace
	 * 
	 * While it is most common for types to be immediate children of the namespace, that is not
	 * necessarily the case.
	 * 
	 * @implNote By default, this method collects all successor types ordered by path. Overriding
	 *           that behavior is not yet supported.
	 * @return the types
	 */
	default CompletableFuture<? extends Collection<? extends TargetNamedDataType<?>>> getTypes() {
		return DebugModelConventions.collectSuccessors(this, TargetNamedDataType.tclass);
	}
}
