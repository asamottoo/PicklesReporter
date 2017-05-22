/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author t.asamoto
 */
public class ReportManager {

	// レポートに出力したい変数を設定
	// キーを変数名として扱う
	// Object内のクラス変数・インスタンス変数を出力
	private static Map<String, Object> values = new HashMap<>();

	// ログ出力パターン
	// 例) 26-10-05 11:30:53.749 INFO Hello world
	private static String logPettern = "%d{yy-MM-dd HH:mm:ss}|%-5level|%msg%n";

	// ログファイル名
	private static String logName = "sample.log";

	// ローテーション後のログファイル命名パターン
	private static String rotationFileNamePattern = "sample_%i.log";

	// ConsoleAppender名
	private static String consoleAppenderName = "CONSOLE_APPENDER";

	// ReportAppender名
	private static String reportAppenderName = "REPORT_APPERNDER";

	// RollingFileAppender名
	private static String rollingAppenderName = "ROLLING_APPERNDER";

	// ログファイル最大サイズ
	private static String rollingFileSize = "10MB";

	// ログファイル世代管理数
	private static String logRolloverStrategy = "50";

}
