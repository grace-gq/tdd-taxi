package com.jiker.keju;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class TaxiPricingTest {
    @Test
    public void should_get_dist_fee_with_starting_price() {
        TaxiPricing taxiPricing = new TaxiPricing(1,0);
        assertThat(taxiPricing.getDistanceFee()).isEqualTo(6, offset(0.01));
    }

    @Test
    public void should_get_dist_fee_when_distance_exceeds_2km() {
        TaxiPricing taxiPricing = new TaxiPricing(3,0);
        assertThat(taxiPricing.getDistanceFee()).isEqualTo(6.8, offset(0.01));
    }

    @Test
    public void should_get_dist_fee_when_distance_exceeds_8km() {
        TaxiPricing taxiPricing = new TaxiPricing(10,0);
        assertThat(taxiPricing.getDistanceFee()).isEqualTo(13.2, offset(0.01));
    }

    @Test
    public void should_get_waiting_fee_when_has_waiting_time() {
        TaxiPricing taxiPricing = new TaxiPricing(2,3);
        assertThat(taxiPricing.getWaitingFee()).isEqualTo(0.75, offset(0.01));
    }

    @Test
    public void should_get_final_fee() {
        TaxiPricing taxiPricing = new TaxiPricing(2,3);
        assertThat(taxiPricing.getFinalFee()).isEqualTo(7);
    }
}
