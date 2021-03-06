package com.acuity.rs.api;


//Generated by the injector on run.

//Extends java/lang/Object
public interface RSSceneElement {

	int getConfig();

	int getEndSceneX();

	int getEndSceneY();

	com.acuity.rs.api.RSRenderable getEntity();

	int getHeight();

	int getOrientation();

	int getPlane();

	int getSceneX();

	int getSceneY();

	int getUID();

	com.acuity.api.rs.wrappers.peers.scene.elements.impl.SceneElement getWrapper();

	void setConfig(int var0);

	void setEndSceneX(int var0);

	void setEndSceneY(int var0);

	void setEntity(com.acuity.rs.api.RSRenderable var0);

	void setHeight(int var0);

	void setOrientation(int var0);

	void setPlane(int var0);

	void setSceneX(int var0);

	void setSceneY(int var0);

	void setUID(int var0);

	void setWrapper(com.acuity.api.rs.wrappers.peers.scene.elements.impl.SceneElement var0);
}
