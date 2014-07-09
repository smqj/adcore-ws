package com.sogou.bizdev.muse.adcorews.app.service.impl;

import java.rmi.RemoteException;
import java.util.List;

import javax.jws.WebService;

import com.sogou.bizdev.muse.adcore.app.dto.AdcoreDto;
import com.sogou.bizdev.muse.adcore.app.service.AdcoreService;
import com.sogou.bizdev.muse.adcorews.app.service.AdcoreWsService;

@WebService(endpointInterface = "com.sogou.bizdev.muse.adcorews.app.service.AdcoreWsService")
public class AdcoreWsServiceImpl implements AdcoreWsService {
	
	private AdcoreService adcoreRmiService;
	
	public AdcoreService getAdcoreRmiService() {
		return adcoreRmiService;
	}

	public void setAdcoreRmiService(AdcoreService adcoreRmiService) {
		this.adcoreRmiService = adcoreRmiService;
	}
	
	@Override
	public AdcoreDto addAdcore(AdcoreDto adcoreDto) throws RemoteException{
		if (adcoreDto != null) {
			return adcoreRmiService.addAdcore(adcoreDto);
		}
		return null;
	}

	@Override
	public void updateAdcore(AdcoreDto adcoreDto)  throws RemoteException{
		if (adcoreDto != null) {
			adcoreRmiService.updateAdcore(adcoreDto);
		}
	}

	@Override
	public void deleteAdcore(Long cpcId)  throws RemoteException{
		AdcoreDto adDto = adcoreRmiService.getById(cpcId);
		if (adDto != null) {
			adcoreRmiService.deleteAdcore(cpcId);
		}		
	}

	@Override
	public List<AdcoreDto> getAll(Integer curPage, Integer pageSize) throws RemoteException {
		return adcoreRmiService.getAll(curPage, pageSize);
	}

	@Override
	public AdcoreDto getById(Long id) throws RemoteException {
		return adcoreRmiService.getById(id);
	}
		
}
