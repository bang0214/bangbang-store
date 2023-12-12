-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: bangbang_store
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '地址主键',
  `linkman` varchar(20) NOT NULL COMMENT '联系人',
  `phone` varchar(13) NOT NULL COMMENT '手机号',
  `address` varchar(200) NOT NULL COMMENT '详细地址',
  `user_id` int DEFAULT NULL COMMENT '用户主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (4,'fdasf','123','afdfa',14),(5,'test','12345678912','scut',16);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_user`
--

DROP TABLE IF EXISTS `admin_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '管理员主键',
  `user_name` varchar(20) DEFAULT NULL COMMENT '管理员昵称',
  `user_account` varchar(40) NOT NULL COMMENT '管理员账号',
  `user_password` varchar(64) NOT NULL COMMENT '管理员密码',
  `user_email` varchar(30) NOT NULL COMMENT '管理员邮箱',
  `create_time` date DEFAULT NULL COMMENT '账号创建时间',
  `user_role` int DEFAULT '0' COMMENT '账号角色编号,用于后期进行权限扩展,前期先为0',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_account` (`user_account`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_user`
--

LOCK TABLES `admin_user` WRITE;
/*!40000 ALTER TABLE `admin_user` DISABLE KEYS */;
INSERT INTO `admin_user` VALUES (1,'老板','admin123','f3eae575297c4c803e220632f73e2789','1181696482@qq.com','2022-11-11',0);
/*!40000 ALTER TABLE `admin_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carousel`
--

DROP TABLE IF EXISTS `carousel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carousel` (
  `carousel_id` int NOT NULL AUTO_INCREMENT,
  `img_path` char(50) NOT NULL,
  `describes` char(50) NOT NULL,
  `product_id` int DEFAULT NULL COMMENT '广告关联的商品图片',
  `priority` int DEFAULT '10' COMMENT '优先级',
  PRIMARY KEY (`carousel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carousel`
--

LOCK TABLES `carousel` WRITE;
/*!40000 ALTER TABLE `carousel` DISABLE KEYS */;
INSERT INTO `carousel` VALUES (1,'public/imgs/cms_1.png','123456',1,10),(2,'public/imgs/cms_2.png','123456',2,10),(3,'public/imgs/cms_3.png','123456',44,10),(4,'public/imgs/cms_4.png','123456',45,10);
/*!40000 ALTER TABLE `carousel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `product_id` int NOT NULL,
  `num` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (13,1,1,2),(25,17,31,1),(26,17,5,1);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` char(20) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'手机'),(2,'电视机'),(3,'空调'),(4,'洗衣机'),(5,'保护套'),(6,'保护膜'),(7,'充电器'),(8,'充电宝'),(9,'智能穿戴');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collect`
--

DROP TABLE IF EXISTS `collect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `collect` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `product_id` int NOT NULL,
  `collect_time` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collect`
--

LOCK TABLES `collect` WRITE;
/*!40000 ALTER TABLE `collect` DISABLE KEYS */;
INSERT INTO `collect` VALUES (11,1,1,1701932484746),(12,13,2,1701937280553);
/*!40000 ALTER TABLE `collect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` bigint NOT NULL,
  `user_id` int NOT NULL,
  `product_id` int NOT NULL,
  `product_num` int NOT NULL,
  `product_price` double NOT NULL,
  `order_time` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (13,1701952181078,13,14,1,2799,1701952181078),(14,1701952181078,13,1,1,4299,1701952181078),(17,1702002630289,14,21,1,19,1702002630289),(23,1702276082552,16,31,2,69,1702276082552),(24,1702276082552,16,5,1,4999,1702276082552),(25,1702278137216,16,7,1,2499,1702278137216),(26,1702278137216,16,44,2,499,1702278137216);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` char(100) NOT NULL,
  `category_id` int NOT NULL,
  `product_title` char(70) NOT NULL,
  `product_intro` text NOT NULL,
  `product_picture` text,
  `product_price` double NOT NULL,
  `product_selling_price` double NOT NULL,
  `product_num` int NOT NULL,
  `product_sales` int NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Xiaomi 14',1,'徕卡光学Summilux镜头','徕卡光学Summilux镜头｜光影猎人900影像传感器 | 75mm徕卡浮动长焦 | 小米澎湃OS ｜第三代骁龙®8移动平台｜小米环形冷泵\n\n','public/imgs/phone/xiaomi14.png',4299,4299,9,2),(2,'Redmi K70 Pro',1,'第三代骁龙8','第三代骁龙8｜小米澎湃OS｜狂暴引擎3.0｜冰封散热系统｜2K 护眼屏｜5000mAh 超大电量','public/imgs/phone/Redmi K70 Pro.png',3299,3299,10,1),(3,'Xiaomi 13 Ultra',1,'徕卡光学全焦段四摄','徕卡光学全焦段四摄| 一英寸可变光圈| 徕卡专业街拍模式| 第二代骁龙8｜2K OLED 屏幕','http://bangbang-store.oss-cn-hangzhou.aliyuncs.com/239dacd233e24890b92e23e8cbab9eb8pms_1681726094.73687921.png?Expires=1703781409&OSSAccessKeyId=LTAI5tBW1EZYquNjKLAABZGd&Signature=WrwwCwLUJSyyZRvx%2BSweRV4V1Ls%3D',5999,5999,100,0),(4,'Xiaomi MIX Fold 3',1,'小米龙骨转轴','小米龙骨转轴|徕卡光学全焦段四摄|小米澎湃电池|双E6旗舰屏幕|第二代骁龙8 领先版|大屏交互|智能大屏','http://bangbang-store.oss-cn-hangzhou.aliyuncs.com/e6378dc3c52242da99cc9faa28f8e75apms_1692003915.92768559.jpg?Expires=1703781591&OSSAccessKeyId=LTAI5tBW1EZYquNjKLAABZGd&Signature=X4Jh2ZWltqUSWc9JCu49FJpqxyU%3D',8999,8999,100,0),(5,'Xiaomi 14 Pro',1,'徕卡Summilux可变光圈镜头','徕卡Summilux可变光圈镜头｜光影猎人900影像传感器 | 小米澎湃OS | 全新小米龙晶玻璃｜全等深微曲屏｜第三代骁龙®8移动平台','http://bangbang-store.oss-cn-hangzhou.aliyuncs.com/bc634f26cffc4daca7a83c8741a7903epms_1698304641.51322936.png?Expires=1703781673&OSSAccessKeyId=LTAI5tBW1EZYquNjKLAABZGd&Signature=n%2BTxplKxcV%2F60KvcPPwarYFA9E8%3D',4999,4999,99,1),(6,'Xiaomi Civi 3',1,'双生双色设计','双生双色设计 | 前置仿生双主摄 | 原生质感人像 | 超轻薄好手感 | 天玑8200-Ultra高性能处理器 | 4500mAh大电池      ','http://bangbang-store.oss-cn-hangzhou.aliyuncs.com/a2a9a0ebd520445b807cb54e050d6e76pms_1684926191.34653090.png?Expires=1703781758&OSSAccessKeyId=LTAI5tBW1EZYquNjKLAABZGd&Signature=s5%2BnfWl6aCD1OqcLmsg%2BcHQbTh0%3D',2799,2799,100,0),(7,'Redmi K70',1,'第二代骁龙8','第二代骁龙8｜小米澎湃OS｜狂暴引擎3.0｜冰封散热系统｜2K 护眼屏  ','http://bangbang-store.oss-cn-hangzhou.aliyuncs.com/cb4ba2336b86432cada24248826e38b8k70.png?Expires=1703781311&OSSAccessKeyId=LTAI5tBW1EZYquNjKLAABZGd&Signature=1KIAVoo%2Br39LnbcKieoZHaw69JM%3D',2499,2499,99,1),(9,'小米电视4A 32英寸',2,'人工智能系统，高清液晶屏','小米电视4A 32英寸 | 64位四核处理器 | 1GB+4GB大内存 | 人工智能系统','public/imgs/appliance/MiTv-4A-32.png',799,799,10,0),(10,'小米全面屏电视E55A',2,'全面屏设计，人工智能语音','全面屏设计 | 内置小爱同学 | 4K + HDR | 杜比DTS | PatchWall | 海量内容 | 2GB + 8GB大存储 | 64位四核处理器','public/imgs/appliance/MiTv-E55A.png',2099,1899,10,0),(11,'小米全面屏电视E65A',2,'全面屏设计，人工智能语音','人工智能语音系统 | 海量影视内容 | 4K 超高清屏 | 杜比音效 | 64位四核处理器 | 2GB + 8GB大存储','public/imgs/appliance/MiTv-E65A.png',3999,2799,10,0),(12,'小米电视4X 43英寸',2,'FHD全高清屏，人工智能语音','人工智能语音系统 | FHD全高清屏 | 64位四核处理器 | 海量片源 | 1GB+8GB大内存 | 钢琴烤漆','public/imgs/appliance/MiTv-4X-43.png',1499,1299,10,0),(13,'小米电视4C 55英寸',2,'4K HDR，人工智能系统','人工智能 | 大内存 | 杜比音效 | 超窄边 | 4K HDR | 海量片源 | 纤薄机身| 钢琴烤漆','public/imgs/appliance/MiTv-4C-55.png',1999,1799,10,0),(14,'小米电视4A 65英寸',2,'4K HDR，人工智能系统','人工智能 | 大内存 | 杜比音效 | 超窄边 | 4K HDR | 海量片源 | 纤薄机身| 钢琴烤漆','public/imgs/appliance/MiTv-4A-65.png',2999,2799,9,1),(15,'小米壁画电视 65英寸',2,'壁画外观，全面屏，远场语音','纯平背板 | 通体13.9mm | 远场语音 | 4K+HDR | 杜比+DTS | 画框模式 | 内置小爱同学 | PatchWall | SoundBar+低音炮 | 四核处理器+大存储','public/imgs/appliance/MiTv-ArtTv-65.png',6999,6999,10,0),(16,'米家互联网空调C1（一级能效）',3,'变频节能省电，自清洁','一级能效 | 1.5匹 | 全直流变频 | 高效制冷/热 | 静音设计 | 自清洁 | 全屋互联','public/imgs/appliance/AirCondition-V1C1.png',2699,2599,20,10),(17,'米家空调',3,'出众静音，快速制冷热','大1匹 | 三级能效 | 静音 | 快速制冷热 | 广角送风 | 除湿功能 | 高密度过滤网 | 典雅外观','public/imgs/appliance/AirCondition-F3W1.png',1799,1699,20,8),(18,'米家互联网洗烘一体机 Pro 10kg',4,'智能洗烘，省心省力','国标双A+级洗烘能力 / 22种洗烘模式 / 智能投放洗涤剂 / 支持小爱同学语音遥控 / 支持OTA在线智能升级 / 智能空气洗 / 除菌率达99.9%+','public/imgs/appliance/Washer-Pro-10.png',2999,2999,20,7),(20,'Xiaomi 14/14 Pro 液态硅胶保护壳',5,'经典原色','经典原色｜ 丝滑触感｜ 整体包裹｜ 镜头保护','public/imgs/accessory/pms_1698651919.72755190.png',99,89,20,10),(21,'Xiaomi 14 高清钢化膜',6,'清晰高透','清晰高透 ｜ 耐磨防刮｜ 舒适手感｜ 轻松秒贴','public/imgs/accessory/pms_1698305039.63688406.png',49,49,30,10),(23,'小米USB充电器30W快充版（1A1C）',7,'多一种接口，多一种选择','双口输出 / 30W 输出 / 可折叠插脚 / 小巧便携','public/imgs/accessory/charger-30w.png',59,59,20,8),(24,'小米USB充电器快充版（18W）',7,'安卓、苹果设备均可使用','支持QC3.0设备充电 / 支持iOS设备充电/ 美观耐用','public/imgs/accessory/charger-18w.png',29,29,20,8),(25,'小米USB充电器60W快充版（6口）',7,'6口输出，USB-C输出接口','6口输出 / USB-C输出接口 / 支持QC3.0快充协议 / 总输出功率60W','public/imgs/accessory/charger-60w.png',129,129,20,0),(26,'小米USB充电器36W快充版（2口）',7,'6多重安全保护，小巧便携','双USB输出接口 / 支持QC3.0快充协议 / 多重安全保护 / 小巧便携','public/imgs/accessory/charger-36w.png',59,59,20,0),(27,'小米车载充电器快充版',7,'让爱车成为移动充电站','QC3.0 双口输出 / 智能温度控制 / 5重安全保护 / 兼容iOS&Android设备','public/imgs/accessory/charger-car.png',69,69,20,0),(28,'小米车载充电器快充版(37W)',7,'双口快充，车载充电更安全','单口27W 快充 / 双口输出 / 多重安全保护','public/imgs/accessory/charger-car-37w.png',49,49,20,0),(29,'小米二合一移动电源（充电器）',7,'一个设备多种用途','5000mAh充沛电量 / 多协议快充 / USB 口输出','public/imgs/accessory/charger-tio.png',99,99,20,0),(30,'小米无线充电宝青春版10000mAh',8,'能量满满，无线有线都能充','10000mAh大容量 / 支持边充边放 / 有线无线都能充 / 双向快充','public/imgs/accessory/charger-10000mAh.png',129,129,20,8),(31,'Xiaomi 13 Ultra科技纳米皮保护壳',5,'别具一格的美学佳作','别具一格的美学佳作 ｜ 细腻触感，工巧耐用 ｜ 抗污耐用，自然亲肤','public/imgs/accessory/pms_1681789557.00389371.png',199,99,18,3),(44,'Redmi Watch 4',9,'1.97英寸AMOLED大屏','1.97英寸AMOLED大屏丨潮流金属表框丨20天超长续航 ','http://bangbang-store.oss-cn-hangzhou.aliyuncs.com/7cd8e68db57e41a2bcf3ee96de715d3dpms_1701917059.31015682.jpg?Expires=1703776701&OSSAccessKeyId=LTAI5tBW1EZYquNjKLAABZGd&Signature=tP3WVzR4vy3uJphUj1gWF4TN%2FeQ%3D',499,499,8,2),(45,'Redmi Buds 5 Pro',9,'同轴双单元 旗舰音质','同轴双单元 旗舰音质 | 52dB/4kHz 旗舰降噪 | 49ms 超低延迟','http://bangbang-store.oss-cn-hangzhou.aliyuncs.com/fdf61789b0a4484da7887d25bc0bbd7cpms_1701099464.46559417.png?Expires=1703780926&OSSAccessKeyId=LTAI5tBW1EZYquNjKLAABZGd&Signature=9tpoCud8i2Ft%2B8LYjSE%2B%2Bg1MtyI%3D',399,399,100,0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_picture`
--

DROP TABLE IF EXISTS `product_picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_picture` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `product_picture` text,
  `intro` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_picture`
--

LOCK TABLES `product_picture` WRITE;
/*!40000 ALTER TABLE `product_picture` DISABLE KEYS */;
INSERT INTO `product_picture` VALUES (1,1,'public/imgs/phone/picture/xiaomi14-1.png',NULL),(2,1,'public/imgs/phone/picture/xiaomi14-2.png',NULL),(3,1,'public/imgs/phone/picture/xiaomi14-3.png',NULL),(4,1,'public/imgs/phone/picture/xiaomi14-4.png',NULL),(5,1,'public/imgs/phone/picture/xiaomi14-5.png',NULL),(6,2,'public/imgs/phone/Redmi K70 Pro.png',NULL),(38,9,'public/imgs/phone/picture/MiTv-4A-32-1.jpg',NULL),(39,9,'public/imgs/phone/picture/MiTv-4A-32-2.jpg',NULL),(40,9,'public/imgs/phone/picture/MiTv-4A-32-3.jpg',NULL),(41,9,'public/imgs/phone/picture/MiTv-4A-32-4.jpg',NULL),(42,10,'public/imgs/phone/picture/MiTv-E55A-1.jpg',NULL),(43,10,'public/imgs/phone/picture/MiTv-E55A-2.jpg',NULL),(44,10,'public/imgs/phone/picture/MiTv-E55A-3.jpg',NULL),(45,10,'public/imgs/phone/picture/MiTv-E55A-4.jpg',NULL),(46,11,'public/imgs/phone/picture/MiTv-E65A-1.jpg',NULL),(47,11,'public/imgs/phone/picture/MiTv-E65A-2.jpg',NULL),(48,11,'public/imgs/phone/picture/MiTv-E65A-3.jpg',NULL),(49,11,'public/imgs/phone/picture/MiTv-E65A-4.jpg',NULL),(50,12,'public/imgs/phone/picture/MiTv-4X 43-1.jpg',NULL),(51,12,'public/imgs/phone/picture/MiTv-4X 43-2.jpg',NULL),(52,12,'public/imgs/phone/picture/MiTv-4X 43-3.jpg',NULL),(53,13,'public/imgs/phone/picture/MiTv-4C 55-1.jpg',NULL),(54,13,'public/imgs/phone/picture/MiTv-4C 55-2.jpg',NULL),(55,13,'public/imgs/phone/picture/MiTv-4C 55-3.jpg',NULL),(56,14,'public/imgs/phone/picture/MiTv-4A 65-1.jpg',NULL),(57,15,'public/imgs/phone/picture/MiTv-ArtTv-65-1.jpg',NULL),(58,16,'public/imgs/phone/picture/AirCondition-V1C1-1.jpg',NULL),(59,17,'public/imgs/phone/picture/AirCondition-F3W1-1.jpg',NULL),(60,18,'public/imgs/phone/picture/Washer-Pro-10-1.jpg',NULL),(61,18,'public/imgs/phone/picture/Washer-Pro-10-2.jpg',NULL),(62,18,'public/imgs/phone/picture/Washer-Pro-10-3.jpg',NULL),(63,18,'public/imgs/phone/picture/Washer-Pro-10-4.jpg',NULL),(65,20,'public/imgs/accessory/pms_1698651919.72755190.png',NULL),(67,21,'public/imgs/accessory/pms_1698305039.63688406.png',NULL),(69,23,'public/imgs/phone/picture/charger-30w-1.jpg',NULL),(70,23,'public/imgs/phone/picture/charger-30w-2.jpg',NULL),(71,23,'public/imgs/phone/picture/charger-30w-3.jpg',NULL),(72,23,'public/imgs/phone/picture/charger-30w-4.jpg',NULL),(73,24,'public/imgs/phone/picture/charger-18w-1.jpg',NULL),(74,24,'public/imgs/phone/picture/charger-18w-2.jpg',NULL),(75,24,'public/imgs/phone/picture/charger-18w-3.jpg',NULL),(76,25,'public/imgs/phone/picture/charger-60w-1.jpg',NULL),(77,25,'public/imgs/phone/picture/charger-60w-2.jpg',NULL),(78,25,'public/imgs/phone/picture/charger-60w-3.jpg',NULL),(79,25,'public/imgs/phone/picture/charger-60w-4.jpg',NULL),(80,26,'public/imgs/phone/picture/charger-36w-1.jpg',NULL),(81,26,'public/imgs/phone/picture/charger-36w-2.jpg',NULL),(82,26,'public/imgs/phone/picture/charger-36w-3.jpg',NULL),(83,26,'public/imgs/phone/picture/charger-36w-4.jpg',NULL),(84,26,'public/imgs/phone/picture/charger-36w-5.jpg',NULL),(85,27,'public/imgs/phone/picture/charger-car-1.jpg',NULL),(86,27,'public/imgs/phone/picture/charger-car-2.jpg',NULL),(87,27,'public/imgs/phone/picture/charger-car-3.jpg',NULL),(88,27,'public/imgs/phone/picture/charger-car-4.jpg',NULL),(89,27,'public/imgs/phone/picture/charger-car-5.jpg',NULL),(90,27,'public/imgs/phone/picture/charger-car-6.jpg',NULL),(91,28,'public/imgs/phone/picture/charger-car-37w-1.jpg',NULL),(92,28,'public/imgs/phone/picture/charger-car-37w-2.jpg',NULL),(93,28,'public/imgs/phone/picture/charger-car-37w-3.jpg',NULL),(94,28,'public/imgs/phone/picture/charger-car-37w-4.jpg',NULL),(95,28,'public/imgs/phone/picture/charger-car-37w-5.jpg',NULL),(96,29,'public/imgs/phone/picture/charger-tio-1.jpg',NULL),(97,29,'public/imgs/phone/picture/charger-tio-2.jpg',NULL),(98,29,'public/imgs/phone/picture/charger-tio-3.jpg',NULL),(99,29,'public/imgs/phone/picture/charger-tio-4.jpg',NULL),(100,29,'public/imgs/phone/picture/charger-tio-5.jpg',NULL),(101,30,'public/imgs/phone/picture/charger-10000mAh-1.jpg',NULL),(102,30,'public/imgs/phone/picture/charger-10000mAh-2.jpg',NULL),(103,30,'public/imgs/phone/picture/charger-10000mAh-3.jpg',NULL),(104,30,'public/imgs/phone/picture/charger-10000mAh-4.jpg',NULL),(105,30,'public/imgs/phone/picture/charger-10000mAh-5.jpg',NULL),(106,31,'public/imgs/accessory/pms_1681789557.00389371.png',NULL),(117,44,'http://bangbang-store.oss-cn-hangzhou.aliyuncs.com/c6aecfddef2542c08f75a79186fecf02pms_1701917059.31015682.jpg?Expires=1703776705&OSSAccessKeyId=LTAI5tBW1EZYquNjKLAABZGd&Signature=qWiV6liF2DAiajegIPOubuiw9tg%3D',NULL),(118,45,'http://bangbang-store.oss-cn-hangzhou.aliyuncs.com/52d9c3f05597428298b182b161ba771fpms_1701099464.46559417.png?Expires=1703780940&OSSAccessKeyId=LTAI5tBW1EZYquNjKLAABZGd&Signature=vHX7uFKZUtPlvEA674kpeeIpeaE%3D',NULL),(119,46,'http://bangbang-store.oss-cn-hangzhou.aliyuncs.com/f5d423a04bf14135a84f71ede79263e8k70.png?Expires=1703781331&OSSAccessKeyId=LTAI5tBW1EZYquNjKLAABZGd&Signature=k1La0wSafUNeBxirSO24ts7wWT0%3D',NULL),(120,47,'http://bangbang-store.oss-cn-hangzhou.aliyuncs.com/075a20457dd540818052379bd8d47c68pms_1681726094.73687921.png?Expires=1703781417&OSSAccessKeyId=LTAI5tBW1EZYquNjKLAABZGd&Signature=rRtrwkGeHMriDUndomeCuIpNb7o%3D',NULL),(121,48,'http://bangbang-store.oss-cn-hangzhou.aliyuncs.com/cef103df32a042a7a090fcbd57c733adpms_1692003915.92768559.jpg?Expires=1703781602&OSSAccessKeyId=LTAI5tBW1EZYquNjKLAABZGd&Signature=0x8rxJx3Oy58TOFRfjBWYjvsF7M%3D',NULL),(122,49,'http://bangbang-store.oss-cn-hangzhou.aliyuncs.com/c3d3ba11256a4958b960df3dbcbb4df9pms_1698304641.51322936.png?Expires=1703781685&OSSAccessKeyId=LTAI5tBW1EZYquNjKLAABZGd&Signature=n8x%2B33jQz%2BzDYp2tJcDeEX%2BEn3A%3D',NULL),(123,50,'http://bangbang-store.oss-cn-hangzhou.aliyuncs.com/7133780ac6bb437aa1932382f81972d9pms_1684926191.34653090.png?Expires=1703781771&OSSAccessKeyId=LTAI5tBW1EZYquNjKLAABZGd&Signature=cjGGntQxSKae3XhNcGORWlTLAo0%3D',NULL);
/*!40000 ALTER TABLE `product_picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` char(40) NOT NULL,
  `PASSWORD` char(40) NOT NULL,
  `user_emailnumber` char(40) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'admin111','8348898D532023C994920A16074C8387',NULL),(3,'admin222','DC483E80A7A0BD9EF71D8CF973673924',NULL),(13,'bang0214','E03345010ED2C434A3A173771ED46091','111'),(16,'admintest','ECE6AA72EA080541F41FFD49076221C5','1181696482@qq.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bangbang_store'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-12 17:01:42
