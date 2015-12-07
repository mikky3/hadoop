/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hdfs.protocol;


import java.io.IOException;
import java.util.List;

import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;
import org.apache.hadoop.conf.ReconfigurationTaskStatus;

/**********************************************************************
 * ReconfigurationProtocol is used by HDFS admin to reload configuration
 * for NN/DN without restarting them.
 **********************************************************************/
@InterfaceAudience.Private
@InterfaceStability.Evolving
public interface ReconfigurationProtocol {

  long versionID = 1L;

  /**
   * Asynchronously reload configuration on disk and apply changes.
   */
  void startReconfiguration() throws IOException;

  /**
   * Get the status of the previously issued reconfig task.
   * @see {@link org.apache.hadoop.conf.ReconfigurationTaskStatus}.
   */
  ReconfigurationTaskStatus getReconfigurationStatus() throws IOException;

  /**
   * Get a list of allowed properties for reconfiguration.
   */
  List<String> listReconfigurableProperties() throws IOException;
}