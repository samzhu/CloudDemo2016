CREATE DATABASE book
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `book` VALUES (1, '億男', '川村元氣');
INSERT INTO `book` VALUES (2, '異境之書：安伯托‧艾可最後人文藝術巨作', '安伯托‧艾可');
INSERT INTO `book` VALUES (3, '窮查理的投資哲學與選股金律', '崔恩‧葛瑞芬');
INSERT INTO `book` VALUES (4, '演算法星球：七天導覽行程，一次弄懂演算法', '賽巴斯提安･史帝樂');
INSERT INTO `book` VALUES (5, '戴美樂小姐的婚禮', '王定國');
INSERT INTO `book` VALUES (6, '超級預測：洞悉思考的藝術與科學，在不確定的世界預見未來優勢', ' 菲利普．泰特洛克');
INSERT INTO `book` VALUES (7, '貓狗的逆襲：荊棘滿途的公民之路', '大衛‧葛林姆');
INSERT INTO `book` VALUES (8, '我還是想你，媽媽：101個失去童年的孩子', '斯維拉娜‧亞歷塞維奇');
INSERT INTO `book` VALUES (9, '咖啡的科學', '崔斯坦．史蒂文森');
INSERT INTO `book` VALUES (10, '被討厭的勇氣：自我啟發之父「阿德勒」的教導', '岸見一郎');
INSERT INTO `book` VALUES (11, '魔法精油寶典：102種植物香氣的能量運用', '史考特‧康寧罕');
INSERT INTO `book` VALUES (12, '天生變態：一個擁有變態大腦的天才科學家', '詹姆斯‧法隆');
