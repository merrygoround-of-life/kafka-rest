/*
 * Copyright 2018 Confluent Inc.
 *
 * Licensed under the Confluent Community License (the "License"); you may not use
 * this file except in compliance with the License.  You may obtain a copy of the
 * License at
 *
 * http://www.confluent.io/confluent-community-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.confluent.kafkarest;

import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import io.confluent.kafkarest.v2.KafkaConsumerManager;
import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.producer.Producer;

public interface KafkaRestContext {

  KafkaRestConfig getConfig();

  /** @deprecated Use {@link #getProducer()} instead. */
  @Deprecated
  ProducerPool getProducerPool();

  KafkaConsumerManager getKafkaConsumerManager();

  Admin getAdmin();

  default Producer<byte[], byte[]> getProducer() {
    return getProducerPool().getProducer();
  }

  default SchemaRegistryClient getSchemaRegistryClient() {
    return null;
  }

  void shutdown();
}
