# Host: localhost  (Version 5.5.19)
# Date: 2016-05-17 09:52:06
# Generator: MySQL-Front 5.3  (Build 5.31)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "course"
#

CREATE TABLE `course` (
  `course_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程Id_逻辑主键',
  `course_no` varchar(20) NOT NULL DEFAULT '' COMMENT '课程编号',
  `course_name` varchar(20) NOT NULL DEFAULT '' COMMENT '课程名',
  `course_type` char(1) NOT NULL DEFAULT '' COMMENT '课程类型',
  `course_credit` float(2,1) unsigned NOT NULL DEFAULT '0.0' COMMENT '学分',
  `course_time` int(3) unsigned NOT NULL DEFAULT '0' COMMENT '学时',
  `course_des` varchar(2550) DEFAULT NULL COMMENT '课程描述',
  PRIMARY KEY (`course_id`),
  UNIQUE KEY `course_no` (`course_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';

#
# Data for table "course"
#


#
# Structure for table "institute"
#

CREATE TABLE `institute` (
  `institute_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '学院id_逻辑主键',
  `institute_no` varchar(20) NOT NULL DEFAULT '' COMMENT '学院编号',
  `institute_name` varchar(20) NOT NULL DEFAULT '' COMMENT '学院名',
  PRIMARY KEY (`institute_id`),
  UNIQUE KEY `institute_no` (`institute_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学院表';

#
# Data for table "institute"
#


#
# Structure for table "manager"
#

CREATE TABLE `manager` (
  `manager_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '管理员id_逻辑主键',
  `manager_no` varchar(20) NOT NULL DEFAULT '' COMMENT '管理员编号',
  `manager_name` varchar(20) NOT NULL DEFAULT '' COMMENT '管理员姓名',
  `manager_sex` char(1) NOT NULL DEFAULT '' COMMENT '管理员性别',
  `manager_birth` date NOT NULL DEFAULT '0000-00-00' COMMENT '管理员出生日期',
  `manager_info` varchar(255) DEFAULT '' COMMENT '管理员简单信息',
  PRIMARY KEY (`manager_id`),
  UNIQUE KEY `manager_no` (`manager_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

#
# Data for table "manager"
#


#
# Structure for table "specialty"
#

CREATE TABLE `specialty` (
  `specialty_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '专业Id_逻辑主键',
  `specialty_no` varchar(20) NOT NULL DEFAULT '' COMMENT '专业编号',
  `specialty_name` varchar(20) NOT NULL DEFAULT '' COMMENT '专业名',
  `institute_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '学院Id',
  PRIMARY KEY (`specialty_id`),
  UNIQUE KEY `specialty_no` (`specialty_no`),
  KEY `institute_id` (`institute_id`),
  CONSTRAINT `specialty_ibfk_1` FOREIGN KEY (`institute_id`) REFERENCES `institute` (`institute_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专业表';

#
# Data for table "specialty"
#


#
# Structure for table "class"
#

CREATE TABLE `class` (
  `class_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `class_no` varchar(20) NOT NULL DEFAULT '0' COMMENT '班级编号',
  `specialty_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '专业id_外键',
  `year` year(4) DEFAULT '0000' COMMENT '年届',
  PRIMARY KEY (`class_id`),
  UNIQUE KEY `class_no` (`class_no`),
  KEY `specialty_id` (`specialty_id`),
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`specialty_id`) REFERENCES `specialty` (`specialty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级';

#
# Data for table "class"
#


#
# Structure for table "student"
#

CREATE TABLE `student` (
  `student_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '学生id_逻辑主键',
  `student_no` varchar(20) NOT NULL DEFAULT '' COMMENT '学号',
  `student_name` varchar(20) NOT NULL DEFAULT '' COMMENT '姓名',
  `student_sex` char(1) NOT NULL DEFAULT '' COMMENT '性别',
  `student_birth` date NOT NULL DEFAULT '0000-00-00' COMMENT '出生日期',
  `student_gpa` float(3,2) unsigned DEFAULT '0.00' COMMENT '绩点',
  `student_grade` float(5,2) unsigned DEFAULT '0.00' COMMENT '综合成绩',
  `class_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '班级id_外键',
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `唯一索引` (`student_no`) COMMENT '确保编号唯一',
  KEY `class_id` (`class_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';

#
# Data for table "student"
#


#
# Structure for table "teacher"
#

CREATE TABLE `teacher` (
  `teacher_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '教师id_主键',
  `teacher_no` varchar(20) NOT NULL DEFAULT '' COMMENT '教师号',
  `teacher_name` varchar(20) NOT NULL DEFAULT '' COMMENT '教师姓名',
  `teacher_sex` char(1) NOT NULL DEFAULT '' COMMENT '教师性别',
  `teacher_birth` date NOT NULL DEFAULT '0000-00-00' COMMENT '教师出生日期',
  `teacher_title` varchar(10) NOT NULL DEFAULT '' COMMENT '教室职称',
  `teacher_info` varchar(255) DEFAULT NULL COMMENT '教师简单信息',
  `institute_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '学院id',
  PRIMARY KEY (`teacher_id`),
  UNIQUE KEY `唯一索引` (`teacher_no`) COMMENT '确保编号唯一',
  KEY `institute_id` (`institute_id`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`institute_id`) REFERENCES `institute` (`institute_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师表';

#
# Data for table "teacher"
#


#
# Structure for table "teach_course"
#

CREATE TABLE `teach_course` (
  `tc_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '教师课程id',
  `teacher_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '教师id',
  `course_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '课程id',
  `limit_count` int(3) unsigned NOT NULL DEFAULT '0' COMMENT '限选人数',
  `term` varchar(6) NOT NULL DEFAULT '201501' COMMENT '开课学期',
  PRIMARY KEY (`tc_id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `teach_course_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `teach_course_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师课程表';

#
# Data for table "teach_course"
#


#
# Structure for table "stu_course"
#

CREATE TABLE `stu_course` (
  `sc_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '学生课程id',
  `student_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '学生id',
  `course_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '课程id',
  `usual_grade` int(3) unsigned DEFAULT '0' COMMENT '平时成绩',
  `term_grade` int(3) unsigned DEFAULT '0' COMMENT '期末成绩',
  `experiment_grade` int(3) unsigned DEFAULT '0' COMMENT '实验成绩',
  `comprehansive_grade` int(3) unsigned DEFAULT '0' COMMENT '综合成绩',
  `makeup_grade` int(3) unsigned DEFAULT '0' COMMENT '补考成绩',
  PRIMARY KEY (`sc_id`),
  KEY `student_id` (`student_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `stu_course_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `teach_course` (`tc_id`),
  CONSTRAINT `stu_course_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生课程表';

#
# Data for table "stu_course"
#


#
# Structure for table "message"
#

CREATE TABLE `message` (
  `message_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '反馈id',
  `teacher_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '教师id_外键',
  `student_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '学生id_外键',
  `message_content` varchar(2550) NOT NULL DEFAULT '' COMMENT '留言内容',
  PRIMARY KEY (`message_id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `message_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='留言表';

#
# Data for table "message"
#


#
# Structure for table "appraise"
#

CREATE TABLE `appraise` (
  `appraise_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '反馈id',
  `teacher_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '教师id_外键',
  `student_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '学生id_外键',
  `appraise_content` varchar(2550) NOT NULL DEFAULT '' COMMENT '评价内容',
  PRIMARY KEY (`appraise_id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `appraise_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  CONSTRAINT `appraise_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评价表';

#
# Data for table "appraise"
#


#
# Structure for table "user"
#

CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL DEFAULT '' COMMENT '用户id_逻辑主键',
  `user_name` varchar(20) NOT NULL DEFAULT '0' COMMENT '用户名',
  `user_password` varchar(20) NOT NULL DEFAULT '' COMMENT '密码',
  `user_role` char(1) NOT NULL DEFAULT '' COMMENT '用户角色',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `唯一索引` (`user_name`) COMMENT '确保user_name唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

#
# Data for table "user"
#

