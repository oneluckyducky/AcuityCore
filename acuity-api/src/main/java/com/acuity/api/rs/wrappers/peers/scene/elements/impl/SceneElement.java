package com.acuity.api.rs.wrappers.peers.scene.elements.impl;

import com.acuity.api.annotations.ClientInvoked;
import com.acuity.api.rs.interfaces.Interactive;
import com.acuity.api.rs.interfaces.Locatable;
import com.acuity.api.rs.wrappers.common.SceneLocation;
import com.acuity.api.rs.wrappers.common.WorldLocation;
import com.acuity.api.rs.utils.UIDs;
import com.acuity.api.rs.wrappers.peers.rendering.Model;
import com.acuity.api.rs.wrappers.peers.rendering.Renderable;
import com.acuity.rs.api.RSSceneElement;
import com.google.common.base.Preconditions;
import com.sun.istack.internal.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Created by Zachary Herridge on 6/9/2017.
 */
public class SceneElement implements Locatable, Interactive, com.acuity.api.rs.wrappers.common.SceneElement {

    private static final Logger logger = LoggerFactory.getLogger(SceneElement.class);

    private RSSceneElement rsSceneElement;

    @ClientInvoked
    public SceneElement(RSSceneElement peer) {
        this.rsSceneElement = Preconditions.checkNotNull(peer);
    }

    public Renderable getEntity(){// TODO: 6/12/2017 Can this be null?
        return rsSceneElement.getEntity().getWrapper();
    }

    public Optional<Model> getModel(){
        return com.acuity.api.rs.wrappers.common.SceneElement.getModel(
                rsSceneElement.getEntity(),
                rsSceneElement.getSceneX(),
                rsSceneElement.getSceneY(),
                rsSceneElement.getOrientation());
    }

    public int getEndSceneX(){
        return rsSceneElement.getEndSceneX();
    }

    public int getFlag(){
        return rsSceneElement.getFlag();
    }

    public int getHeight(){
        return rsSceneElement.getHeight();
    }

    public int getOffsetX(){
        return rsSceneElement.getOffsetX();
    }

    public int getOffsetY(){
        return rsSceneElement.getOffsetY();
    }

    public int getOrientation(){
        return rsSceneElement.getOrientation();
    }

    @Override
    public WorldLocation getWorldLocation() {
        return new SceneLocation(getSceneX(), getSceneY(), getPlane()).getWorldLocation();
    }

    public int getPlane(){
        return rsSceneElement.getPlane();
    }

    public int getSceneX(){
        return rsSceneElement.getSceneX();
    }

    public int getSceneY(){
        return rsSceneElement.getSceneY();
    }

    public int getID(){
        return getUID().getEntityID();
    }

    public UIDs.UID getUID(){
        return new UIDs.UID(rsSceneElement.getUID());
    }

    @NotNull
    public RSSceneElement getRsSceneElement() {
        return rsSceneElement;
    }
}