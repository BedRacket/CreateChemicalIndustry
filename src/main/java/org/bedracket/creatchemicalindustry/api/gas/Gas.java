package org.bedracket.creatchemicalindustry.api.gas;

/**
 * Gas API to make a gas block
 * implements it to block which should be a gas block
 */
public interface Gas {

    /**
     * A method to get gas type
     * @return new gas type
     */
    EGasType getGasType();

}
