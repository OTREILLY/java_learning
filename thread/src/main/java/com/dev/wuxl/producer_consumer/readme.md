生产/消费者问题是个非常典型的多线程问题，涉及到的对象包括“生产者”、“消费者”、“仓库”和“产品”。他们之间的关系如下：
(01) 生产者仅仅在仓储未满时候生产，仓满则停止生产。
(02) 消费者仅仅在仓储有产品时候才能消费，仓空则等待。
(03) 当消费者发现仓储没产品可消费时候会通知生产者生产。
(04) 生产者在生产出可消费产品时候，应该通知等待的消费者去消费。