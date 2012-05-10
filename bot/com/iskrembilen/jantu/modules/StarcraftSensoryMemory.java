package com.iskrembilen.jantu.modules;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.iskrembilen.jantu.model.Unit;
import edu.memphis.ccrg.lida.framework.shared.ConcurrentHashSet;
import edu.memphis.ccrg.lida.sensorymemory.SensoryMemoryImpl;

public class StarcraftSensoryMemory extends SensoryMemoryImpl {

	private Set<Unit> unitObjects = new ConcurrentHashSet<Unit>();
	private Set<Unit> buildingObjects = new ConcurrentHashSet<Unit>();
	private Set<Unit> mineralObjects = new ConcurrentHashSet<Unit>();
	private Set<Unit> geyserObjects = new ConcurrentHashSet<Unit>();
	
 
    private Map<String,Object> sensorParam = new HashMap<String, Object>();

    @Override
    public void init() {
    }

    @Override
    public void runSensors() {
    	sensorParam.put("mode","units");
    	unitObjects.clear();
    	unitObjects.addAll((Set<Unit>) environment.getState(sensorParam));
    	
    	sensorParam.put("mode","buildings");
    	buildingObjects.clear();
    	buildingObjects.addAll((Set<Unit>) environment.getState(sensorParam));
    	
    	sensorParam.put("mode","minerals");
    	mineralObjects.clear();
    	mineralObjects.addAll((Set<Unit>) environment.getState(sensorParam));
    	
    	sensorParam.put("mode","geysers");
    	geyserObjects.clear();
    	geyserObjects.addAll((Set<Unit>) environment.getState(sensorParam));
    }

    @Override
    public Object getSensoryContent(String string, Map<String, Object> params) {
        String mode = (String)params.get("mode");
        if("units".equals(mode)) {
            return unitObjects;
        } else if("buildings".equals(mode)){
            return buildingObjects;
        } else if("minerals".equals(mode)){
            return mineralObjects;
        } else if("geysers".equals(mode)){
            return geyserObjects;
        }
        return null;
    }
    
    @Override
    public void decayModule(long l) {
        //NA
    }
    
    @Override
    public Object getModuleContent(Object... os) {
        return null;
    }

}