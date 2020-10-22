package com.acme.blogging.MemberShip.controller;

import com.acme.blogging.Initialization.domain.model.Customer;
import com.acme.blogging.Initialization.resource.CustomerResource;
import com.acme.blogging.Initialization.resource.SaveCustomerResource;
import com.acme.blogging.MemberShip.domain.model.Plan;
import com.acme.blogging.MemberShip.domain.service.PlanService;
import com.acme.blogging.MemberShip.resource.PlanResource;
import com.acme.blogging.MemberShip.resource.SavePlanResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Plans", description = "MemberShip API")
@RestController
@RequestMapping("api/")
public class PlanController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PlanService planService;

    @GetMapping("/plans")
    public Page<PlanResource> getAllPlans(Pageable pageable){
        Page<Plan> planPage = planService.getAllPlans(pageable);
        List<PlanResource> resources = planPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }

    @GetMapping("/plans/{price}")
    public Page<PlanResource> getAllPlansByPriceLessThanEqual(@Valid @PathVariable (value = "price") Long price,
                                                              Pageable pageable){
        Page<Plan> planPage = planService.getAllPlansByPriceLessThanEqual(price,pageable);
        List<PlanResource> resources = planPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }

    @GetMapping("/plans/{planId}/id")
    public PlanResource getPlanById(@Valid @PathVariable (value = "planId") Long planId){
        return convertToResource(planService.getPlanById(planId));
    }

    @GetMapping("/plans/{planName}/name")
    public PlanResource getPlanByName(@Valid @PathVariable (value = "planName") String planName){
        return convertToResource(planService.getPlanByName(planName));
    }

    @PostMapping("/plans")
    public PlanResource createPlan(@Valid @RequestBody SavePlanResource resource){
        Plan plan = convertToEntity(resource);
        return convertToResource(planService.createPlan(plan));
    }

    @PutMapping("/plans/{planId}")
    public PlanResource updatePlan(@Valid @PathVariable (value = "planId") Long planId,
                                   SavePlanResource resource){
        Plan plan = convertToEntity(resource);
        return convertToResource(planService.updatePlan(planId,plan));
    }

    @DeleteMapping("/plans/{planId}")
    public ResponseEntity<?> deletePlan(@Valid @PathVariable (value = "planId") Long planId){
        planService.deletePlan(planId);
        return ResponseEntity.ok().build();
    }

    private PlanResource convertToResource(Plan plan){
        return mapper.map(plan, PlanResource.class);
    }

    private Plan convertToEntity(SavePlanResource resource){
        return mapper.map(resource, Plan.class);
    }
}
