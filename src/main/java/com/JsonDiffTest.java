package com;

import com.alibaba.fastjson.JSONObject;
import com.vue.utils.CompareJson;
import com.vue.utils.DifferJson;

public class JsonDiffTest {
    public static void main(String[] args) {
        DifferJson differJson = new DifferJson();
        String str1 = "{\"code\":0,\"msg\":\"success11\",\"nowTime\":1568965854,\"data\":{\"seller\":{\"fansNum\":191,\"saleNum\":326372,\"promotionTips\":\"\",\"isCostFreeUser\":true,\"sharePlusAllowed\":0,\"isShowSharePlusRed\":0,\"assetsTotal\":\"1689815.15\",\"buyerNoticeNum\":1,\"waitPayNum\":0,\"notDeliveryNum\":137,\"sellerAfterSaleNum\":44,\"waitReceiveNum\":1,\"sellerNoticeNum\":181,\"heartWordsNum\":0,\"pdLibStatus\":1,\"pdLibEntry\":1,\"double11Tips\":\"\",\"collegeOfSideText\":{\"title\":\"\",\"titleColor\":\"\"},\"isInvite\":0,\"msgNum\":19,\"lastShopId\":0,\"sellerinfo\":{\"headimgurl\":\"https:\\/\\/cdn01t.weipaitang.com\\/certify\\/20190823zao7s2gf-smjs-w96y-wshe-u8hngtykvotu-W96H96\\/w\\/132\",\"nickname\":\"\\u54c8\\u54c8\\u54c8111122\",\"memberTime\":1525401974,\"sellerLevelScores\":10017,\"sellerLevel\":6,\"sellerLevelIconUrl\":\"https:\\/\\/cdn.weipaitang.com\\/static\\/20190812bf21e59f-a5d4-47dd-bc0e-cf85ab4a6023-W84H45\",\"balance\":\"19,870,143.71\"},\"isShowAgreement\":false,\"liveDepotTips\":false,\"hasHonor\":false,\"showNewBuyerGuide\":false,\"merchantLawType\":2,\"groupShow\":0},\"showDashboard\":1}}";
        String str2 = "{\"code\":1,\"msg\":\"success11\",\"nowTime\":1568965856,\"data\":{\"seller\":{\"fansNum\":191,\"saleNum\":326372,\"promotionTips\":\"\",\"isCostFreeUser\":true,\"sharePlusAllowed\":0,\"isShowSharePlusRed\":0,\"assetsTotal\":\"1689815.15\",\"buyerNoticeNum\":1,\"waitPayNum\":0,\"notDeliveryNum\":137,\"sellerAfterSaleNum\":44,\"waitReceiveNum\":1,\"sellerNoticeNum\":181,\"heartWordsNum\":0,\"pdLibStatus\":1,\"pdLibEntry\":1,\"double11Tips\":\"\",\"collegeOfSideText\":{\"title\":\"\",\"titleColor\":\"\"},\"isInvite\":0,\"msgNum\":19,\"lastShopId\":0,\"sellerinfo\":{\"headimgurl\":\"https:\\/\\/cdn01t.weipaitang.com\\/certify\\/20190823zao7s2gf-smjs-w96y-wshe-u8hngtykvotu-W96H96\\/w\\/132\",\"nickname\":\"\\u54c8\\u54c8\\u54c8111122\",\"memberTime\":1525401974,\"sellerLevelScores\":10017,\"sellerLevel\":6,\"sellerLevelIconUrl\":\"https:\\/\\/cdn.weipaitang.com\\/static\\/20190812bf21e59f-a5d4-47dd-bc0e-cf85ab4a6023-W84H45\",\"balance\":\"19,870,143.71\"},\"isShowAgreement\":false,\"liveDepotTips\":false,\"hasHonor\":false,\"showNewBuyerGuide\":false,\"merchantLawType\":2,\"groupShow\":0},\"showDashboard\":1}}";


//        String str2 = "{\"code\":0,\"msg\":\"success\",\"nowTime\":1568965856,\"data\":{\"seller\":{\"saleNum\":4118,\"promotionTips\":\"\",\"isCostFreeUser\":true,\"sharePlusAllowed\":0,\"isShowSharePlusRed\":0,\"assetsTotal\":\"1689815.15\",\"buyerNoticeNum\":1,\"waitPayNum\":0,\"notDeliveryNum\":137,\"sellerAfterSaleNum\":44,\"waitReceiveNum\":1,\"sellerNoticeNum\":181,\"pdLibStatus\":1,\"pdLibEntry\":1,\"double11Tips\":\"\",\"collegeOfSideText\":{\"title\":\"\",\"titleColor\":\"\"},\"isInvite\":0,\"msgNum\":19,\"lastShopId\":0,\"sellerinfo\":{\"headimgurl\":\"https:\\/\\/cdn01t.weipaitang.com\\/certify\\/20190823zao7s2gf-smjs-w96y-wshe-u8hngtykvotu-W96H96\\/w\\/132\",\"nickname\":\"\\u54c8\\u54c8\\u54c8111122\",\"memberTime\":1525401974,\"sellerLevelScores\":10017,\"sellerLevel\":6,\"sellerLevelIconUrl\":\"https:\\/\\/cdn.weipaitang.com\\/static\\/20190812bf21e59f-a5d4-47dd-bc0e-cf85ab4a6023-W84H45\",\"balance\":\"19,870,143.71\"},\"isShowAgreement\":false,\"liveDepotTips\":false,\"hasHonor\":false,\"showNewBuyerGuide\":false,\"merchantLawType\":2,\"groupShow\":0},\"showDashboard\":1}}";
//
//        JSONObject result = CompareJ
        JSONObject jsonObject1 = JSONObject.parseObject(str1);
        JSONObject jsonObject2 = JSONObject.parseObject(str2);

        JSONObject result = CompareJson.compareJsonObject(str1, str2);
        System.out.println("当前字段比对通过: " + differJson.diffFormatJson(jsonObject2, jsonObject1,"").toString());
//        System.out.println("当前字段比对通过: " + result);
    }

}
