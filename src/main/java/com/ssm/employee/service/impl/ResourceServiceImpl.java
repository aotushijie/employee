package com.ssm.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.employee.dao.ResourceMapper;
import com.ssm.employee.pojo.EmployeeInfo;
import com.ssm.employee.pojo.ResourceInfo;
import com.ssm.employee.service.ResourceService;
@Service
public class ResourceServiceImpl implements ResourceService {
	@Autowired
	private ResourceMapper resourceMapper;
	
	public void setEmployeeInfoMapper(ResourceMapper resourceMapper) {
		this.resourceMapper = resourceMapper;
	}
	@Override
	public PageInfo<EmployeeInfo> findResources(int pageNo) {
		//���÷�ҳ��ҳ�롢ÿҳ��¼��
		PageHelper.startPage(pageNo, 10);
		//��ѯȫ�����������ļ�¼
		List<EmployeeInfo> list = resourceMapper.findResources();
		//���÷�ҳ��Ϣ����ǰҳ�롢ÿҳ�������ܼ�¼������ҳ����ǰһҳҳ�롢��һҳҳ�롢�Ƿ��һҳ���Ƿ����һҳ����ǰҳ�ļ�¼��������
		PageInfo<EmployeeInfo> page = new PageInfo<>(list);
		return page;
	}

}
