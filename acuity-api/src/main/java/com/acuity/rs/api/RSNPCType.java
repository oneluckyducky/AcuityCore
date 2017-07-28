package com.acuity.rs.api;


//Generated by the injector on run.

//Extends com/acuity/rs/api/RSCacheableNode
public interface RSNPCType extends RSCacheableNode {

	java.lang.String[] getActions();

	short[] getColors();

	int getID();

	int getIdleAnimation();

	java.lang.String getName();

	short[] getNewColorscolors();

	short[] getNewTextures();

	int getPrayerIcon();

	com.acuity.rs.api.RS3CopiedNodeTable getProperties();

	int getScaleXY();

	int getScaleZ();

	int getSize();

	short[] getTexturesnewTextures();

	int[] getTransformIDs();

	int getVarpbitIndex();

	int getVarpIndex();

	int getWalkAnimation();

	com.acuity.api.rs.wrappers.peers.types.NpcType getWrapper();

	boolean isRenderedOnMinimap();

	boolean isRenderingPrioritized();

	void setActions(java.lang.String[] var0);

	void setColors(short[] var0);

	void setID(int var0);

	void setIdleAnimation(int var0);

	void setName(java.lang.String var0);

	void setNewColorscolors(short[] var0);

	void setNewTextures(short[] var0);

	void setPrayerIcon(int var0);

	void setProperties(com.acuity.rs.api.RS3CopiedNodeTable var0);

	void setRenderedOnMinimap(boolean var0);

	void setRenderingPrioritized(boolean var0);

	void setScaleXY(int var0);

	void setScaleZ(int var0);

	void setSize(int var0);

	void setTexturesnewTextures(short[] var0);

	void setTransformIDs(int[] var0);

	void setVarpbitIndex(int var0);

	void setVarpIndex(int var0);

	void setWalkAnimation(int var0);

	void setWrapper(com.acuity.api.rs.wrappers.peers.types.NpcType var0);
}
