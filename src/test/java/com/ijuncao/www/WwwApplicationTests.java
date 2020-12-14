package com.ijuncao.www;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import javax.validation.Path.ConstructorNode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ijuncao.www.mapper.DeviceMapper;
import com.ijuncao.www.model.Device;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.pattern.CronPattern;
import cn.hutool.cron.task.Task;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;


@SpringBootTest
class WwwApplicationTests {
	
	@Autowired
	private  DeviceMapper  deviceMapper;


	@Test
	void contextLoads() {
	}
	
	/**
	 * 生成excel文件
	 */
	@Test
	void  newExcel(){
		List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
		List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
		List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
		List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
		List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
		List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
		ExcelWriter writer = ExcelUtil.getWriter("d:/writeTest.xlsx");
		//跳过当前行，既第一行，非必须，在此演示用
		writer.passCurrentRow();
		//合并单元格后的标题行，使用默认标题样式
		writer.merge(row1.size() - 1, "测试标题");
		//一次性写出内容，强制输出标题
		writer.write(rows, true);
		//关闭writer，释放内存
		writer.close();
	}
	/**
	 * 发送邮件
	 */
	@Test
	void  sendmail(){
		MailUtil.send("22590570@qq.com", "测试", "<h1>邮件来自Hutool测试</h1>", true, FileUtil.file("d:/writeTest.xlsx"));
	}
	
	@Test
	void newTask() {
		CronUtil.schedule("任务1", "0/6 * * * * ? *", new Task() {
			@Override
			public void execute() {
				// TODO Auto-generated method stub
				System.out.println("执行任务1");
			}
		});
		CronUtil.setMatchSecond(true);
		CronUtil.start(true);
	}
	
	@Test
	void  deleteORremove(){
		  CronUtil.remove("任务1");
	}
	
	@Test
	void  updateCron() {
		 CronPattern c = new CronPattern("0/2 * * * * ? *");
		 CronUtil.updatePattern("任务1", c);
	}
	
	@Test
	void  dataread() {
		 ExecutorService executor = ThreadUtil.newExecutor(15);
	        for (int i = 0; i < 20; i++) {
	            executor.execute(() -> handler());
	        }
	        executor.shutdown();
	}

    public static void handler() {
        //打印当前线程名字
        System.out.println("当前执行线程：" + Thread.currentThread().getName());
    }
    @Test
    void  device() {
    	HashMap<String, Object> paramMap = new HashMap<>();
    	paramMap.put("appid", "qA*LKDK_VFe1gUj$");
    	paramMap.put("secret", "4-7rU$5CiXUr2jDk4dNfVnc5x84iAQBw");
    	String result3= HttpUtil.get("http://openapi.ecois.info//v3/token", paramMap);
    	System.out.println(result3);
    	JSONObject info = JSONUtil.parseObj(result3);
    	Map  map  =JSONUtil.toBean(info, Map.class);
    	String token = (String) map.get("token");
    	
    	HashMap<String, Object> paramMap1 = new HashMap<>();
    	paramMap1.put("page", 1);
    	paramMap1.put("limit", 10000);
    	String result2 = HttpRequest.get("http://openapi.ecois.info/v3/devices")
    		    .header(Header.AUTHORIZATION, token)//头信息，多个头信息多次调用此方法即可
    		    .form(paramMap1)//表单内容
    		    .timeout(20000)//超时，毫秒
    		    .execute().body();
    	JSONObject info1 = JSONUtil.parseObj(result2);
    	JSONArray  ds = (JSONArray) info1.get("list");
    	List<Device> devices = new ArrayList<Device>();
    	for (int i = 0; i < ds.size(); i++) {
			JSONObject  d = (JSONObject) ds.get(i);
			JSONObject  location = (JSONObject) d.get("location");
			JSONObject  status = (JSONObject) d.get("status");
			Device  dn  = new Device(d.getStr("sn"),d.getStr("alias") , d.getStr("type") , d.getStr("series"), status.getStr("code"),location.getStr("city") , location.getStr("district"),  location.getStr("lat"),  location.getStr("lng"), location.getStr("province"));
			devices.add(dn);
		}
    	deviceMapper.insertDeviceInfo(devices);
    }
    
  
	
	

}
