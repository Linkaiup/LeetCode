# Redis

### 第一部分：数据结构与对象

#### 一、SDS

- Redis 只会使用 C 字符串作为字面量， 在大多数情况下， Redis 使用 SDS （Simple Dynamic String，简单动态字符串）作为字符串表示。
- 比起 C 字符串， SDS 具有以下优点：
  1. 常数复杂度获取字符串长度，因为sds当中有存len，free，buf[]。
  2. 杜绝缓冲区溢出（通过检查空间是否足够的方式）。
  3. 减少修改字符串长度时所需的内存重分配次数。
  4. 二进制安全。
  5. 兼容部分 C 字符串函数。

#### 二、链表

- 分为节点结构和链表结构
- 链表被广泛用于实现 Redis 的各种功能， 比如列表键， 发布与订阅， 慢查询， 监视器， 等等。
- 每个链表节点由一个 `listNode` 结构来表示， 每个节点都有一个指向前置节点和后置节点的指针， 所以 Redis 的链表实现是双端链表。
- 每个链表使用一个 `list` 结构来表示， 这个结构带有表头节点指针、表尾节点指针、以及链表长度等信息。
- 因为链表表头节点的前置节点和表尾节点的后置节点都指向 `NULL` ， 所以 Redis 的链表实现是无环链表。
- **多态**：链表**使用void\*指针来保存节点的值**，通过为链表设置不同的类型特定函数， Redis 的链表可以用于保存各种不同类型的值。

#### 三、字典(dict)

- 字典被广泛用于实现 Redis 的各种功能， 其中包括**数据库和哈希键**。
- Redis 中的字典使用哈希表作为底层实现， 每个字典带有两个哈希表， 一个用于平时使用， 另一个仅在进行 rehash 时使用。
- 当字典被用作数据库的底层实现， 或者哈希键的底层实现时， Redis 使用 MurmurHash2 算法来计算键的哈希值。
- 哈希表使用链地址法来解决键冲突， 被分配到同一个索引上的多个键值对会连接成一个单向链表。
- 在对哈希表进行扩展或者收缩操作时， 程序需要将现有哈希表包含的所有键值对 rehash 到新哈希表里面， 并且这个 rehash 过程并不是一次性地完成的， 而是**渐进式地完成的，分多次完成**。在 rehash 期间，对哈希表的查找，删除，修改，会先在 ht[0] 进行。没找到，则会去 ht[1] 中找，并操作。增加则加到 ht[1] 中。 
- rehash条件：负载因子（load factor）计算：load_factor =ht[0].used / ht[0].size，即负载因子大小等于当前哈希表的键值对数量，除以当前哈希表的大小

#### 四、跳跃表(skiplist)

- 跳跃表是有序集合的**底层实现之一**， 除此之外它在 Redis 中没有其他应用。
- Redis 的跳跃表实现由 `zskiplist` 和 `zskiplistNode` 两个结构组成， 其中 `zskiplist` 用于保存跳跃表信息（比如表头节点、表尾节点、长度）， 而 `zskiplistNode` 则用于表示跳跃表节点。
- 每个跳跃表节点的层高都是 `1` 至 `32` 之间的随机数。
- 在同一个跳跃表中， 多个节点可以包含相同的分值， 但每个节点的成员对象必须是唯一的。
- 跳跃表中的节点按照分值大小进行排序， 当分值相同时， 节点按照成员对象的大小进行排序。

#### 五、整数集合(intset)

- 整数集合是**集合键的底层实现之一**。
- 整数集合的底层实现为数组， 这个数组以有序、无重复的方式保存集合元素， 在有需要时， 程序会根据新添加元素的类型， 改变这个数组的类型。
- 升级操作为整数集合带来了操作上的灵活性， 并且尽可能地节约了内存。
- 整数集合只支持升级操作， 不支持降级操作。

#### 六、压缩列表(ziplist)

- 压缩列表是一种为节约内存而开发的顺序型数据结构。
- 压缩列表被用作**列表键和哈希键**的底层实现之一。
- 压缩列表可以包含多个节点，每个节点可以保存一个字节数组或者整数值。
- 添加新节点到压缩列表， 或者从压缩列表中删除节点， 可能会引发连锁更新操作， 但这种操作出现的几率并不高。

#### 七、对象

- Redis 数据库中的每个键值对的键和值都是一个对象。
- Redis 共有**字符串、列表、哈希、集合、有序集合**五种类型的对象， 每种类型的对象至少都有两种或以上的编码方式， 不同的编码可以在不同的使用场景上优化对象的使用效率。
- 服务器在执行某些命令之前， 会先检查给定键的类型能否执行指定的命令， 而检查一个键的类型就是检查键的值对象的类型。
- Redis 的对象系统带有引用计数实现的内存回收机制， 当一个对象不再被使用时， 该对象所占用的内存就会被自动释放。
- Redis 会共享值为 `0` 到 `9999` 的字符串对象。
- 对象会记录自己的最后一次被访问的时间， 这个时间可以用于计算对象的空转时间。

### 第二部分：使用 Redis的数据类型

#### 一、操作集合

https://linhunger.github.io/2017/11/20/Redis%EF%BC%9A%E5%88%9D%E8%AF%86%E4%BB%8B%E7%BB%8D%EF%BC%88%E4%B8%80%EF%BC%89/

#### 二、字符串

#### 三、哈希

#### 四、集合

- 不可重复，无序
- sadd；srem ；scard；sismember；spop；smembers；sinter/sunion/sdif
- 场景：标签、社交

#### 五、列表

- 可重复，有序，能通过索引下标获取元素
- lpush/rpush/linsert；lrange/lindex/llen；lpop/rpop/lrem/ltrim；lset；blpop/brpop
- 场景：时间轴、消息队列

#### 六、有序集合

- 不可重复，有序：通过分数排序
- zadd；zrank/zrevzrank；zrangebyscore；zcount
- 场景：排行榜

#### 七、操作命令

1. keys：会一次性返回所有匹配的结果，对内存和服务器性能有影响

2. 使用scan：SCAN cursor(游标参数) [MATCH pattern]    / [COUNT count]。

   SCAN 每次执行都只会返回**少量元素**，所以可以用于生产环境，而不会出现像 [KEYS](http://www.redis.cn/commands/keys.html) 或者 [SMEMBERS](http://www.redis.cn/commands/smembers.html) 命令带来的可能会阻塞服务器的问题。

### 第三部分：Redis 的缓存策略

#### 一、maxmemory

可在 redis.conf 文件中配置：maxmemory 100mb

#### 二、驱逐策略：maxmemory-policy

- **noeviction**：不删除策略, 达到最大内存限制时, 如果需要更多内存, 直接返回错误信息。 大多数写命令都会导致占用更多的内存(有极少数会例外, 如 [DEL](https://redis.io/commands/del) )。
- **allkeys-lru**: 所有key通用; 优先删除**最近最少**使用(less recently used ,LRU) 的 key。
- **volatile-lru**: 只限于设置了 **expire** 的部分; 优先删除最近最少使用(less recently used ,LRU) 的 key。
- **allkeys-random**: 所有key通用; 随机删除一部分 key
- **volatile-random**: 只限于设置了 **expire** 的部分; 随机删除一部分 key
- **volatile-ttl**: 只限于设置了 **expire** 的部分; 优先删除剩余时间(time to live,TTL) 短的key

#### 三、常规操作

- 如果分为热数据与冷数据, 推荐使用 allkeys-lru 策略。 也就是, 其中一部分key经常被读写. 如果不确定具体的业务特征, 那么 **allkeys-lru** 是一个很好的选择。因为 expire 会消耗额外内存，使用 allkeys-lru 也可以更高效地利用内存。
- 如果需要循环读写所有的key, 或者各个key的访问频率差不多, 可以使用 **allkeys-random** 策略, 即读写所有元素的概率差不多。
- 假如要让 Redis 根据 TTL 来筛选需要删除的key, 请使用 **volatile-ttl** 策略

#### 四、具体实现

- 在这个过程中, 内存使用量会不断地达到 limit 值, 然后超过, 然后删除部分 key, 使用量又下降到 limit 值之下
- 如果某个命令导致大量内存占用(比如通过新key保存一个很大的set), 在一段时间内, 可能内存的使用量会明显超过 maxmemory 限制。

#### 五、LRU 近似度

- 使用 pool 来作为候选
- `CONFIG SET maxmemory-samples <count>` ：count是样本数量

### 第四部分：redis 功能使用场景

- **订阅-发布系统**Pub/Sub 从字面上理解就是发布（Publish）与订阅（Subscribe），在 Redis 中，你可以设定对某一个 key 值进行消息发布及消息订阅，当一个 key 值上进行了消息发布后，所有订阅它的客户端都会收到相应的消息。这一功能最明显的用法就是用作实时消息系统，比如普通的即时聊天，群聊等功能。

- **事务——Transactions**

  谁说 NoSQL 都不支持事务，虽然 Redis 的 Transactions 提供的并不是严格的 ACID 的事务（比如一串用 EXEC 提交执行的命令，在执行中服务器宕机，那么会有一部分命令执行了，剩下的没执行），但是这个 Transactions 还是提供了基本的命令打包执行的功能（在服务器不出问题的情况下，可以保证一连串的命令是顺序在一起执行的，中间不会有其它客户端命令插进来执行）。Redis 还提供了一个 Watch 功能，你可以对一个 key 进行 Watch，然后再执行 Transactions，在这过程中，如果这个 Watched 的值进行了修改，那么这个 Transactions 会发现并拒绝

- set 集合交集，并集，差集等操作

- Bitmap：逻辑并、逻辑或、逻辑异或和逻辑非

- BITFIELD 命令

- bitmap 使用场景

- ```java
  //用户签到
  Jedis redis = new Jedis("192.168.31.89",6379,100000);
  //用户uid
  String uid = "1";
  String cacheKey = "sign_"+Integer.valueOf(uid);
  //记录有uid的key
  // $cacheKey = sprintf("sign_%d", $uid);
  
  //开始有签到功能的日期
  String startDate = "2017-01-01";
  
  //今天的日期
  String todayDate = "2017-01-21";
  
  //计算offset(时间搓)
  long startTime = dateParase(startDate,"yyyy-MM-dd").getTime();
  long todayTime = dateParase(todayDate,"yyyy-MM-dd").getTime();
  long offset = (long) Math.floor((todayTime - startTime) / 86400);
  
  System.out.println("今天是第"+offset+"天");
  
  //签到
  //一年一个用户会占用多少空间呢？大约365/8=45.625个字节，好小，有木有被惊呆？
  redis.setbit(cacheKey,offset,"1");
  
  //查询签到情况
  boolean bitStatus = redis.getbit(cacheKey, offset);
  //判断是否已经签到
  //计算总签到次数
  long qdCount = redis.bitcount(cacheKey);
  ```

- ```java
  //统计活跃用户数
  Map<String,List<Integer>>dateActiveuser = new HashMap<>();
  Jedis redis = new Jedis("192.168.31.89",6379,100000);
  Integer[] temp01 = {1,2,3,4,5,6,7,8,9,10};
  List<Integer>temp01List = new ArrayList<>();
  Collections.addAll(temp01List,temp01);
  dateActiveuser.put("2017-01-10",temp01List);
  
  
  Integer[] temp02 = {1,2,3,4,5,6,7,8};
  List<Integer>temp02List = new ArrayList<>();
  Collections.addAll(temp02List,temp02);
  dateActiveuser.put("2017-01-11",temp02List);
  
  Integer[] temp03 = {1,2,3,4,5,6};
  List<Integer>temp03List = new ArrayList<>();
  Collections.addAll(temp03List,temp03);
  dateActiveuser.put("2017-01-12",temp03List);
  
  Integer[] temp04 = {1,4,5,6};
  List<Integer>temp04List = new ArrayList<>();
  Collections.addAll(temp04List,temp04);
  dateActiveuser.put("2017-01-13",temp04List);
  
  Integer[] temp05 = {1,4,5,6};
  List<Integer>temp05List = new ArrayList<>();
  Collections.addAll(temp05List,temp05);
  dateActiveuser.put("2017-01-14",temp05List);
  
  String date[] = {"2017-01-10","2017-01-11","2017-01-12","2017-01-13","2017-01-14"};
  
  //测试数据放入redis中
  for (int i=0;i<date.length;i++){
      for (int j=0;j<dateActiveuser.get(date[i]).size();j++){
          redis.setbit(date[i], dateActiveuser.get(date[i]).get(j), "1");
      }
  }
  
  //bitOp
  redis.bitop(BitOP.AND, "stat", "stat_2017-01-10", "stat_2017-01-11","stat_2017-01-12");
  
  System.out.println("总活跃用户："+redis.bitcount("stat"));
  
  redis.bitop(BitOP.AND, "stat1", "stat_2017-01-10", "stat_2017-01-11","stat_2017-01-14");
  System.out.println("总活跃用户："+redis.bitcount("stat1"));
  
  redis.bitop(BitOP.AND, "stat2", "stat_2017-01-10", "stat_2017-01-11");
  System.out.println("总活跃用户："+redis.bitcount("stat2"));
  ```


### 第五部分：如何用 Redis 实现分布式锁

#### 一、单机的实现

1. 获取锁

   ```sql
   #客户端向 Redis 发送命令
   SET resource_name my_random_value NX PX 30000
   NX 表示只有当resource_name对应的key值不存在的时候才能SET成功
   ```

2. 释放锁

   ```lua
   if redis.call("get",KEYS[1]) == ARGV[1] then
       return redis.call("del",KEYS[1])
   else
       return 0
   end
   ```

#### 二、Redis集群实现分布式锁

1. RedLock 获取锁

   获取到锁的Redis节点个数多于N/2+1，而且整个获取锁的过程消耗的时间不超过锁的最初有效时间。即获取成功

2. RedLock 释放锁

   客户端向所有Redis节点发起释放锁操作