/* 
 * @(#)Test.java    Created on 2013-5-23
 * Copyright (c) 2013 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.xuan.utils;

/**
 * 不同编码中文的字节数
 * 
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2013-5-23 下午12:32:33 $
 */
public class Test {
    public static void main(String[] args) {
        // System.out.println(FriendlyTimeUtils.friendly_time("2013-06-21 15:48:32"));
        // System.out.println(FriendlyTimeUtils.friendly_time("2013-06-21 15:38:32"));
        // System.out.println(FriendlyTimeUtils.friendly_time("2013-06-21 12:39:32"));
        System.out.println(SecurityUtils.encodeByMD5("111"));
    }

}
