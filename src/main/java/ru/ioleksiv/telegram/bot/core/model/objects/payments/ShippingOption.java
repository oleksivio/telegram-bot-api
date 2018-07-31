package ru.ioleksiv.telegram.bot.core.model.objects.payments;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @see <a href="https://core.telegram.org/bots/api#shippingoption>ShippingOption</a>
 */
public class ShippingOption {
    /**
     * id	String	Shipping option identifier
     */
    @JsonProperty("id")
    private String id = null;
    /**
     * title	String	Option title
     */
    @JsonProperty("title")
    private String title = null;
    /**
     * prices	Array of LabeledPrice	List of price portions
     */
    @JsonProperty("prices")
    private List<LabeledPrice> prices = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<LabeledPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<LabeledPrice> prices) {
        this.prices = prices;
    }
}
