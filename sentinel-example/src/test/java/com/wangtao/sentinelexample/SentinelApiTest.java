package com.wangtao.sentinelexample;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtao
 * Created at 2022/6/27 20:08
 */
public class SentinelApiTest {

    @Test
    public void testFlowRule() {
        initFlowRules();
        while (true) {
            try (Entry entry = SphU.entry("hello")) {
                // 被保护的逻辑
                System.out.println("hello world");
            } catch (BlockException ex) {
                // 处理被流控的逻辑
                System.out.println("blocked!");
            }
        }
    }

    private void initFlowRules() {
        List<FlowRule> flowRules = new ArrayList<>();
        FlowRule flowRule = new FlowRule();
        flowRule.setResource("hello");
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setCount(20);
        flowRules.add(flowRule);
        FlowRuleManager.loadRules(flowRules);
    }
}
