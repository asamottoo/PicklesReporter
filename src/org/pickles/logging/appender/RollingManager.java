/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.appender;

import java.util.HashSet;

/**
 *
 * @author t.asamoto
 */
public class RollingManager {
	
	//ローリング対象ファイル名セット
	private static HashSet<String> targetSet = new HashSet<String>();

	//ローリング対象がなかった場合の待ち時間(ミリ秒)を設定します。
	private static long waitTimeMillis = 60000l;
	
	/**
	 * ローリング処理実行スレッドを定義します。
	 */
	private static Thread executor = new Thread(new Runnable(){
		
		/**
		 * 永久ループ内でローリング処理を実行します。<br>
		 * RollingManagerで定義したインスタンス変数の値に基づき処理します。<br>
		 * ターゲットがない場合はデフォルトで60000ミリ秒（1分）処理を停止します。
		 */
		@Override
		public void run() {
			while(true){
				
				// スタックされたターゲット内容を確認する
				if(targetSet.isEmpty()){
					try {
						Thread.sleep(waitTimeMillis);
					} catch (InterruptedException ex) {}
				}else{
					for(String target : targetSet){
						roll(target);
					}
				}
			}
		}
		
		/**
		 * ローリング処理を行います。<br>
		 * 引数にターゲットとなるファイル名及びパスを記述します。
		 * @param target 
		 */
		synchronized private void roll(String target){
			// ファイルのロックを確認する
			// ファイルのロックを取得する
			// ファイルを別名でコピーする
			// コピー元のファイルを削除及び新規作成する
			// ファイルのロックを解除する
		}

	});	
	
	/**
	 * ローリング対象となるファイル名を設定します。
	 * @param targetName 
	 */
	public static void addTarget(String targetName){
		targetSet.add(targetName);
	}
	
	/**
	 * ローリング対象が何も設定されていない場合の待ち時間を設定します。<br>
	 * デフォルトでは1分となっています。
	 * @param time 
	 */
	public static void setWaitTime(long time){
		waitTimeMillis = time;
	}
	
}
