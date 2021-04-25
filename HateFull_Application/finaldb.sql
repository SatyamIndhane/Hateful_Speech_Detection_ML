# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     pvg_new_hate_ful
# Server version:               5.1.73-community
# Server OS:                    Win32
# HeidiSQL version:             5.0.0.3272
# Date/time:                    2020-04-22 19:16:57
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
# Dumping database structure for pvg_new_hate_ful
CREATE DATABASE IF NOT EXISTS `pvg_new_hate_ful` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `pvg_new_hate_ful`;


# Dumping structure for table pvg_new_hate_ful.nlptest
CREATE TABLE IF NOT EXISTS `nlptest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` text,
  `twittedpost` text,
  `stopword` text,
  `stemmer` text,
  `ClassifyLabel` text,
  `Comment_ID` text,
  `nbclass` text,
  `svmclass` text,
  `dtclass` text,
  `Score_NB` text,
  `Score_SVM` text,
  `Score_DT` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

# Dumping data for table pvg_new_hate_ful.nlptest: 2 rows
/*!40000 ALTER TABLE `nlptest` DISABLE KEYS */;
INSERT INTO `nlptest` (`id`, `username`, `twittedpost`, `stopword`, `stemmer`, `ClassifyLabel`, `Comment_ID`, `nbclass`, `svmclass`, `dtclass`, `Score_NB`, `Score_SVM`, `Score_DT`) VALUES (1, 'abc@gmail.com', '\r\nI take the assumption that your Nation is so crap is not worth remembering .', ',assumption,Nation,crap,worth,remembering,', ',assumption,nation,crap,worth,remember,', 'Offensive', '1', 'Clear', 'Offensive', 'Offensive', '0.0', '0.6863893140862404', '0.5345224838248488'), (2, 'satyam@gmail.com', '\r\nThe House Judiciary Committee just voted to hold Attorney General Bill Barr in contempt', ',House,Judiciary,Committee,voted,hold,Attorney,General,Bill,Barr,contempt,', ',house,judiciary,committee,vote,hold,attorney,general,bill,barr,contempt,', 'Clear', '2', 'Clear', 'Clear', 'Hateful', '0.0', '0.8495606211641505', '0.4082482904638631');
/*!40000 ALTER TABLE `nlptest` ENABLE KEYS */;


# Dumping structure for table pvg_new_hate_ful.nlptrain
CREATE TABLE IF NOT EXISTS `nlptrain` (
  `T_ID` int(11) NOT NULL AUTO_INCREMENT,
  `twittedpost` text,
  `stopword` text,
  `stemmer` text,
  `ClassLabel` text,
  PRIMARY KEY (`T_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

# Dumping data for table pvg_new_hate_ful.nlptrain: 50 rows
/*!40000 ALTER TABLE `nlptrain` DISABLE KEYS */;
INSERT INTO `nlptrain` (`T_ID`, `twittedpost`, `stopword`, `stemmer`, `ClassLabel`) VALUES (1, 'In order to help increase the booklets downloads , it would be great if all Stormfronters who had YouTube accounts , could display the following text in the description boxes of their uploaded YouTube videos .', 'order,help,increase,booklets,downloads,great,Stormfronters,YouTube,accounts,display,text,description,boxes,uploaded,YouTube,videos,', 'order,help,increase,booklet,download,great,stormfronter,youtube,account,display,text,description,boxe,uploade,youtube,video,', 'Offensive'), (2, 'Click below for a FREE download of a colorfully illustrated 132 page e-book on the Zionist-engineered INTENTIONAL destruction of Western civilization .', 'Click,FREE,download,colorfully,illustrated,book,Zionist,engineered,INTENTIONAL,destruction,Western,civilization,', 'click,free,download,color,illustrate,book,zionist,engineere,intention,destruction,western,civilize,', 'Clear'), (3, 'Click below for a FREE download of a colorfully illustrated 132 page e-book on the Zionist-engineered INTENTIONAL destruction of Western civilization .', 'Click,FREE,download,colorfully,illustrated,book,Zionist,engineered,INTENTIONAL,destruction,Western,civilization,', 'click,free,download,color,illustrate,book,zionist,engineere,intention,destruction,western,civilize,', 'Offensive'), (4, 'Booklet updated on Dec. 9th , 2013 .', 'Booklet,updated,Dec,', 'booklet,update,dec,', 'Clear'), (5, 'Thank you in advance. : ) Download the youtube `` description box \'\' info text file below @ http://www.mediafire.com/download/gxv2b33v37la6pz/Booklet % 20Description % 20Box % 20Info.txt', 'advance,Download,youtube,description,box,info,text,file,mediafire,download,gxv,la,pz,Booklet,Description,Box,Info,txt,', 'advance,download,youtube,description,box,info,text,file,mediafire,download,gxv,la,pz,booklet,description,box,info,txt,', 'Clear'), (6, 'She may or may not be a Jew but she \'s certainly stupid , she seems to think the Blacks wo n\'t kill her alongside every other White they can get their dirty hands on , what a muppet !', 'Jew,stupid,Blacks,wo,kill,alongside,White,dirty,hands,muppet,', 'jew,stupid,black,wo,kill,alongside,white,dirty,hand,muppet,', 'Offensive'), (7, 'God knows what would come out of Africa if only blacks could come up with investigative journalism .', 'God,Africa,blacks,investigative,journalism,', 'god,africa,black,investig,journal,', 'Hateful'), (8, 'I\'m insulted by how stupid the Jews think we are until I see what they see by reading the posts amongst our so-called , `` Awakened Brethren . \'\'', 'insulted,stupid,Jews,reading,posts,Awakened,Brethren,', 'insulte,stupid,jew,read,posts,awakene,brethren,', 'Clear'), (9, 'We are trying to get people in every White nation around the world to distribute White Nationalist flyers on Saturday night , October 13th .', 'people,White,nation,distribute,White,Nationalist,flyers,Saturday,night,October,', 'people,white,nation,distribute,white,nationalist,flyer,saturday,night,october,', 'Offensive'), (10, 'Does it surprise you that jews promote faggotry ?', 'surprise,jews,promote,faggotry,', 'surprise,jew,promote,faggotry,', 'Offensive'), (11, 'It \'s another way to destroy Hungarians on top of promoting * * * * * * music , race mixing and pornography .', 'destroy,Hungarians,top,promoting,music,race,mixing,pornography,', 'destroy,hungarian,top,promot,music,race,mix,pornography,', 'Offensive'), (12, 'I watch fights on gay parade in budapest together with my friends from hungary , we were together on vacation in one croatian island , it was great to watch how hungarian nationalists were smashing gay parade btw I have some hungarian blood , my grandmother was hungarian Kitartas !', 'watch,fights,gay,parade,budapest,friends,hungary,vacation,croatian,island,great,watch,hungarian,nationalists,smashing,gay,parade,btw,hungarian,blood,grandmother,hungarian,Kitartas,', 'watch,fight,gay,parade,budapest,friend,hungary,vacation,croatian,island,great,watch,hungarian,nationalists,smash,gay,parade,btw,hungarian,blood,grandmother,hungarian,kitarta,', 'Clear'), (13, 'i have been talking about it for years. the filthy muslims putting their sight on africa. in some ways they are worst then blacks .', 'talking,years,filthy,muslims,putting,sight,africa,ways,worst,blacks,', 'talk,year,filthy,muslim,put,sight,africa,way,worst,black,', 'Hateful'), (14, 'We have a little piece of legislation called the Prohibition of Foreign Military Assistance Act This prohibits mercs from operating in South Africa. on pain of five years of hell in a kaffer jail .', 'piece,legislation,Prohibition,Foreign,Military,Assistance,prohibits,mercs,operating,South,Africa,pain,years,hell,kaffer,jail,', 'piece,legislation,prohibition,foreign,military,assistance,prohibit,merc,operat,south,africa,pain,year,hell,kaffer,jail,', 'Offensive'), (15, 'You are welcome to grab on if you like !', 'grab,', 'grab,', 'Clear'), (16, 'I know one thing , no white should ever give one nickel or a second thought to Africa for they have repaid good with evil .', 'thing,white,nickel,second,thought,Africa,repaid,good,evil,', 'thing,white,nickel,second,thought,africa,repaid,good,evil,', 'Hateful'), (17, 'I have no idea of how many might be here .', 'idea,', 'idea,', 'Offensive'), (18, 'Only if they get their collective heads out of the punch bowl and wake up to what \'s going on in the world .', 'collective,heads,punch,bowl,wake,going,', 'collective,head,punch,bowl,wake,go,', 'Hateful'), (19, 'Our brothers & sisters in SA must stand their ground because they have earned through the blood and sweat of their ancestors .', 'brothers,sisters,SA,stand,ground,earned,blood,sweat,ancestors,', 'brother,sister,sa,stand,ground,earne,blood,sweat,ancestor,', 'Offensive'), (20, 'It is hard to say what is going to happen however one way or the other I think Whites in South Africa should get out of the country and try to make it to a safer location such as Canada or Australia .', 'hard,going,happen,Whites,South,Africa,country,safer,location,Canada,Australia,', 'hard,go,happen,white,south,africa,country,safer,location,canada,australia,', 'Clear'), (21, 'Were Whites to leave in large numbers leaving few Whites behind in South Africa the country would start going down hill and then maybe more Whites would begin to see what losers Negros are and how they cannot even maintain what is given to them .', 'Whites,leave,large,numbers,leaving,Whites,South,Africa,country,start,going,hill,Whites,losers,Negros,maintain,', 'white,leave,large,number,leav,white,south,africa,country,start,go,hill,white,loser,negro,maintain,', 'Offensive'), (22, 'I\'m looking to study at a college in South Africa later in my life .', 'study,college,South,Africa,life,', 'study,college,south,africa,life,', 'Offensive'), (23, 'Here\'s a site that compiles news articles of white crime and degeneracy .', 'site,compiles,news,articles,white,crime,degeneracy,', 'site,compile,new,article,white,crime,degeneracy,', 'Clear'), (24, 'I also , unfortuantely , spent 7-8th grade in a 95 % monkey house .', 'unfortuantely,spent,grade,monkey,house,', 'unfortuante,spent,grade,monkey,house,', 'Hateful'), (25, 'It wasnt really that dangerous perse , just stinky , and dumb , with the poor 5 % white kids the outcasts , which made some of them hooligans and crazy .', 'dangerous,perse,stinky,dumb,poor,white,kids,outcasts,hooligans,crazy,', 'dangerou,perse,stinky,dumb,poor,white,kid,outcasts,hooligan,crazy,', 'Clear'), (26, 'I was basically a babysitter , and the apes went nuts , and frankly , I could not control them and had to press the panic button twice to get someone to help me .', 'basically,babysitter,apes,nuts,frankly,control,press,panic,button,help,', 'basic,babysitter,ape,nut,frank,control,pres,panic,button,help,', 'Clear'), (27, 'Went outside for recess , and noticed two niglet boys being hostile and ready to rumble , and I figured right that they jumped on each other after returning to class , grabbing Niglet Number One , hauling him outside and pressed that panic button again .', 'recess,noticed,niglet,boys,hostile,ready,rumble,figured,jumped,returning,class,grabbing,Niglet,Number,hauling,pressed,panic,button,', 'reces,notice,niglet,boy,hostile,ready,rumble,figure,jumpe,return,clas,grab,niglet,number,haul,presse,panic,button,', 'Clear'), (28, 'I like to listen to this preacher , but why do black prreachers always have to scream .', 'listen,preacher,black,prreachers,scream,', 'listen,preacher,black,prreacher,scream,', 'Clear'), (29, 'I think you should write a book as well .', 'write,book,well,', 'write,book,well,', 'Hateful'), (30, 'I guess I \'ll just stick to homeschooling my kids , when and if I have them ...', 'guess,ll,stick,homeschooling,kids,', 'gues,ll,stick,homeschool,kid,', 'Clear'), (31, 'I could n\'t imagine living in those conditions with drugs and filthy negros everywhere .', 'imagine,living,conditions,drugs,filthy,negros,', 'imagine,live,condition,drug,filthy,negro,', 'Hateful'), (32, 'Here is the guy \'s blog from the radio station he works at .', 'guy,blog,radio,station,works,', 'guy,blog,radio,station,work,', 'Clear'), (33, 'Is n\'t it interesting how genocide is a crime until it happens to Europeans ?', 'interesting,genocide,crime,Europeans,', 'interest,genocide,crime,european,', 'Clear'), (34, 'It \'s why they do n\'t take real ones seriously .', 'real,seriously,', 'real,serious,', 'Hateful'), (35, 'I feel so sorry for all you people living there , wish you could all move here hopefully you do n\'t suffer like your neighbours in zimbabwe .', 'feel,people,living,move,hopefully,suffer,neighbours,zimbabwe,', 'feel,people,live,move,hope,suffer,neighbour,zimbabwe,', 'Offensive'), (36, 'It is in the nature of Jews to desecrate traditions of all sorts and push our women to make fools of themselves .', 'nature,Jews,desecrate,traditions,sorts,push,women,fools,', 'nature,jew,desecrate,tradition,sort,push,women,fool,', 'Hateful'), (37, 'But I love this song and video so I thought I d post it here since the topic is about him .', 'love,song,video,thought,post,topic,', 'love,song,video,thought,post,topic,', 'Clear'), (38, 'A has been from a genre called `` grunge rock \'\' AKA sheety music popular around 20 years ago I did n\'t like them then and now ... same consensus Pearl Jam - Jeremy - YouTube', 'genre,grunge,rock,AKA,sheety,music,popular,years,ago,consensus,Pearl,Jam,Jeremy,YouTube,', 'genre,grunge,rock,aka,sheety,music,popular,year,ago,consensus,pearl,jam,jeremy,youtube,', 'Hateful'), (39, 'My wife had to spend time at the UP Hospital in Philadelphia - thank God I was licensed to carry in Pa. Downtown Philadelphia is becoming a cesspool .', 'wife,spend,time,Hospital,Philadelphia,God,licensed,carry,Pa,Downtown,Philadelphia,cesspool,', 'wife,spend,time,hospital,philadelphia,god,license,carry,pa,downtown,philadelphia,cesspool,', 'Clear'), (40, 'Their gods often had pale skin and blue eyes but I suppose literacy is n\'t valued highly by their cultural intelligencia .', 'gods,pale,skin,blue,eyes,suppose,literacy,valued,highly,cultural,intelligencia,', 'god,pale,skin,blue,eye,suppose,literacy,value,high,cultural,intelligencia,', 'Hateful'), (41, 'Richard Anthony March 2 , 2014 A Storm is Brewing on the Horizon ?', 'Richard,Anthony,March,Storm,Brewing,Horizon,', 'richard,anthony,march,storm,brew,horizon,', 'Clear'), (42, 'As usual the magic negro opens his mouth and lies pour forth .', 'usual,magic,negro,opens,mouth,lies,pour,', 'usual,magic,negro,open,mouth,lie,pour,', 'Hateful'), (43, 'If lies were money he would be the richest negro in the world', 'lies,money,richest,negro,', 'lie,money,richest,negro,', 'Clear'), (44, 'Great image of the Jew as a poisonous mushroom .', 'Great,image,Jew,poisonous,mushroom,', 'great,image,jew,poisonou,mushroom,', 'Hateful'), (45, 'The majority of the people in these photos are more of the threat to America than to the Ukraine in my opinion .', 'majority,people,photos,threat,America,Ukraine,opinion,', 'majoriti,people,photo,threat,america,ukraine,opinion,', 'Clear'), (46, 'well, the liberals would go ape crazy .', 'well,liberals,ape,crazy,', 'well,liberal,ape,crazy,', 'Hateful'), (47, 'And there \'s no need for a video game , just pack concealed carry and walk around any major US city after dark .', 'video,game,pack,concealed,carry,walk,major,city,dark,', 'video,game,pack,conceale,carry,walk,major,city,dark,', 'Offensive'), (48, 'It would be great if we could get every last white out of there so no one would be there to fix things .', 'great,white,things,', 'great,white,thing,', 'Clear'), (49, 'Wow Is there some hope for the Negro race ?', 'Wow,hope,Negro,race,', 'wow,hope,negro,race,', 'Clear'), (50, 'It would be nice to see Negro leaders like that take charge and lead their people home .', 'nice,Negro,leaders,charge,lead,people,', 'nice,negro,leader,charge,lead,people,', 'Clear');
/*!40000 ALTER TABLE `nlptrain` ENABLE KEYS */;


# Dumping structure for table pvg_new_hate_ful.tblclassify
CREATE TABLE IF NOT EXISTS `tblclassify` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `Username` text,
  `Class_Lable_NB` text,
  `Class_Lable_SVM` text,
  `Class_Lable_DT` text,
  `Score_NB` text,
  `Score_SVM` text,
  `Score_DT` text,
  `Comment_ID` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=latin1;

# Dumping data for table pvg_new_hate_ful.tblclassify: 0 rows
/*!40000 ALTER TABLE `tblclassify` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblclassify` ENABLE KEYS */;


# Dumping structure for table pvg_new_hate_ful.tbltime
CREATE TABLE IF NOT EXISTS `tbltime` (
  `NB_Time` text,
  `DT_Time` text,
  `SVM_Time` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table pvg_new_hate_ful.tbltime: 1 rows
/*!40000 ALTER TABLE `tbltime` DISABLE KEYS */;
INSERT INTO `tbltime` (`NB_Time`, `DT_Time`, `SVM_Time`) VALUES ('443', '709', '289');
/*!40000 ALTER TABLE `tbltime` ENABLE KEYS */;


# Dumping structure for table pvg_new_hate_ful.testingdata
CREATE TABLE IF NOT EXISTS `testingdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` text,
  `tweet_comment` text,
  `User_ID` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

# Dumping data for table pvg_new_hate_ful.testingdata: 2 rows
/*!40000 ALTER TABLE `testingdata` DISABLE KEYS */;
INSERT INTO `testingdata` (`id`, `username`, `tweet_comment`, `User_ID`) VALUES (1, 'abc@gmail.com', '\r\nI take the assumption that your Nation is so crap is not worth remembering .', '1'), (2, 'satyam@gmail.com', '\r\nThe House Judiciary Committee just voted to hold Attorney General Bill Barr in contempt', '1');
/*!40000 ALTER TABLE `testingdata` ENABLE KEYS */;


# Dumping structure for table pvg_new_hate_ful.trainingdata
CREATE TABLE IF NOT EXISTS `trainingdata` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `Word_Data` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table pvg_new_hate_ful.trainingdata: 0 rows
/*!40000 ALTER TABLE `trainingdata` DISABLE KEYS */;
/*!40000 ALTER TABLE `trainingdata` ENABLE KEYS */;


# Dumping structure for table pvg_new_hate_ful.userdetail
CREATE TABLE IF NOT EXISTS `userdetail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `address` text,
  `userid` text,
  `mobile` text,
  `password` text,
  `status_msg` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

# Dumping data for table pvg_new_hate_ful.userdetail: 2 rows
/*!40000 ALTER TABLE `userdetail` DISABLE KEYS */;
INSERT INTO `userdetail` (`ID`, `name`, `address`, `userid`, `mobile`, `password`, `status_msg`) VALUES (1, 'abc', 'pune', 'abc@gmail.com', '8888888888', '123', '0'), (2, 'aa', 'pune', 'satyam@gmail.com', '8888888888', 'aA@123', '0');
/*!40000 ALTER TABLE `userdetail` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
