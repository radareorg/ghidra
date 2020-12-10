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
package agent.dbgeng.model.iface2;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import agent.dbgeng.model.iface1.DbgModelSelectableObject;
import ghidra.dbg.target.TargetLauncher;
import ghidra.dbg.target.TargetMethod.TargetParameterMap;

public interface DbgModelTargetConnector
		extends DbgModelSelectableObject, TargetLauncher<DbgModelTargetConnector> {

	@Override
	public default String getDisplay() {
		return getName();
	}

	@Override
	public CompletableFuture<Void> select();

	@Override
	public TargetParameterMap getParameters();

	@Override
	public CompletableFuture<Void> launch(Map<String, ?> args);
}
